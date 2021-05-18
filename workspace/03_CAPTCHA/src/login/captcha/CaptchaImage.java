package login.captcha;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

// 네이버 캡차 API 예제 - 캡차 이미지 수신
public class CaptchaImage {

	// 기존의 main()메소드를
	// 캡차 이미지를 받아 오는 getChptchaImage()로 변환
	// 1. 반환타입 : 없어도됨 void
	// 2. 메소드명 : getChptchaImage
	// 3. 매개변수 : HttpServletRequest request(리얼패스 구하기 위해 필요), String key (발급받은 캡차키 값)
    public static void getChptchaImage(HttpServletRequest request, String key) {
    	 String clientId = "CjhZfNffyKXraAOwgJsO";		//애플리케이션 클라이언트 아이디값";
         String clientSecret = "QQlcaJLmMI"; 			//애플리케이션 클라이언트 시크릿값";

        // key값을 매개변수로 받아오기 때문에 아래 문장 필요없음
        // key = "CAPTCHA_KEY"; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
        String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(request, apiURL,requestHeaders);

        //System.out.println(responseBody); 계속해서 찍히기 때문에 없애기
    }

    private static String get(HttpServletRequest request, String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return getImage(request, con.getInputStream());
            } else { // 에러 발생
                return error(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String getImage(HttpServletRequest request, InputStream is){
        int read;
        byte[] bytes = new byte[1024];
        // 타임스탬프 값으로 파일 생성
        String filename = Long.valueOf(new Date().getTime()).toString() + ".jpg";
        
        //캠차 이미지를 저장할 디렉터리
        final String DIR = "captcha_storage";
        
        //captcha_storage의 실제 경로를 알아내기
        //realPath를 알아내려면 request가 필요하다.
        String realPath = request.getServletContext().getRealPath(DIR);
        
        //realPath에 디렉터리가 생성되지 않았다면 생성하는 코드
        File dir =  new File(realPath);
        if (!dir.exists()) {	//존재하지않으면
        	dir.mkdir();		//만들어라
        }
        
        //File("디렉터리 경로 / 파일")
        //File("디렉터리 경로", "파일")
        File f = new File(realPath, filename);	//realPath에 저장하도록 수정
        try(OutputStream outputStream = new FileOutputStream(f)){
            f.createNewFile();
            while ((read = is.read(bytes)) != -1) {	//파일복사
                outputStream.write(bytes, 0, read);
            }
            //Login.java로부터 받은 request를 사용하기 때문에
            //여기에서 request에 데이터를 저장하면 Login.java도 저장된 데이터를 사용 할 수 있다.
            //캡차 이미지 다운로드 성공한 지점
            //캡차 이미지 경로 + 파일명을 request에저장한다.
            request.setAttribute("DIR", DIR);	//Login.java가 사용할 수 있도록 저장
            request.setAttribute("filename", filename);		//Login.java가 사용할 수 있도록 저장
            
            return "이미지 캡차가 생성되었습니다.";
        } catch (IOException e) {
            throw new RuntimeException("이미지 캡차 파일 생성에 실패 했습니다.",e);
        }
    }

    private static String error(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}