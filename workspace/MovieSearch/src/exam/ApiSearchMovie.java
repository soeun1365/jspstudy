package exam;

//네이버 검색 API예제는 블로그를 비롯 전문자료까지 호출방법이 동일하므로 blog검색만 대표로 예제를 올렸습니다.
// 네이버 검색 API 예제 - blog 검색
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

		public class ApiSearchMovie {

		    public static void main(String[] args) {
		        String clientId = "N8iUUCQuKnadIBRMdZPb"; //애플리케이션 클라이언트 아이디값"
		        String clientSecret = "u2hGoyNzN7"; //애플리케이션 클라이언트 시크릿값"


		        String text = null;
		        try {
		            text = URLEncoder.encode("그린팩토리", "UTF-8");
		        } catch (UnsupportedEncodingException e) {
		            throw new RuntimeException("검색어 인코딩 실패",e);
		        }


		        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // json 결과
		        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


		        Map<String, String> requestHeaders = new HashMap<>();
		        requestHeaders.put("X-Naver-Client-Id", clientId);
		        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		        
		        String responseBody = "{\"코미디\" : [\r\n" + 
		        		"	{  \"title\" : \"어 리얼리 다크 코미디\"\r\n" + 
		        		"	   \"pubdate\" : 2002\r\n" + 
		        		"	   \"actor\" : \"김철수\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"로맨틱 코미디\"\r\n" + 
		        		"	   \"pubdate\" : 2001\r\n" + 
		        		" 	   \"actor\" : \"김민지\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"나는 원래 대전에서 로맨틱 코미디를 찍으려고 했었다\"\r\n" + 
		        		"	   \"pubdate\" : 1999\r\n" + 
		        		" 	   \"actor\" : \"김미소\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"앨런 앤더스: 라이브앳 더 코미디 캐슬 - 써카 1987\"\r\n" + 
		        		"	   \"pubdate\" : 2002\r\n" + 
		        		" 	   \"actor\" : \"김민수\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"더 히스토리 오브 코미디\"\r\n" + 
		        		"	   \"pubdate\" : 1999\r\n" + 
		        		" 	   \"actor\" : \"박서준\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"웜 코미디 어바웃 디프레션, 매드니스 앤 언풀필드 드림즈\"\r\n" + 
		        		"	   \"pubdate\" : 2020\r\n" + 
		        		"	    \"actor\" : \"송중기\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"칸사이 자니스 주니어 코미디 스타 탄생!\"\r\n" + 
		        		"	   \"pubdate\" : 2012\r\n" + 
		        		"	    \"actor\" : \"김우빈\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"스탠드 업! 코미디\"\r\n" + 
		        		"	   \"pubdate\" : 2007\r\n" + 
		        		"	    \"actor\" : \"송중기\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"더 코미디 클럽\"\r\n" + 
		        		"	   \"pubdate\" : 2005\r\n" + 
		        		"	    \"actor\" : \"송중기\"\r\n" + 
		        		"	}\r\n" + 
		        		"],\r\n" + 
		        		"\"호러\" : [\r\n" + 
		        		"	{  \"title\" : \"주온\"\r\n" + 
		        		"	   \"pubdate\" : 2012\r\n" + 
		        		"	    \"actor\" : \"스칼렛\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"링\"\r\n" + 
		        		"	   \"pubdate\" : 2007\r\n" + 
		        		"	    \"actor\" : \"제임스\"\r\n" + 
		        		"	},\r\n" + 
		        		"	{  \"title\" : \"좀비랜드\"\r\n" + 
		        		"	   \"pubdate\" : 2005\r\n" + 
		        		"	    \"actor\" : \"마이클\"\r\n" + 
		        		"	}\r\n" + 
		        		"]\r\n" + 
		        		"}";   
		        
		        String comedy_title = "";
		        Scanner sc = new Scanner(System.in);
		        System.out.println("영화에 관련된 검색어를 입력하세요. ex) 코미디, 호러");
		        String search = sc.next();
				try {
					JSONParser parser = new JSONParser();
					JSONObject obj = (JSONObject)parser.parse(responseBody);

					JSONArray comedy = (JSONArray)obj.get(search);
					//System.out.println(comedy);
					
					for (int i = 0 ; i < comedy.size() ; i++) {
						JSONObject obj2 = (JSONObject)comedy.get(i);
						comedy_title += obj2.get("title").toString() + "\n";
						//System.out.println(comedy_title);
					}
					FileWriter fw = null;
					try {
						fw = new FileWriter("search_result.txt");
						fw.write(comedy_title);
						System.out.println("search_result 파일이 저장되었습니다.");
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(fw != null) {fw.close();}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
		     }   
		
		    private static String get(String apiUrl, Map<String, String> requestHeaders){
		        HttpURLConnection con = connect(apiUrl);
		        try {
		            con.setRequestMethod("GET");
		            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
		                con.setRequestProperty(header.getKey(), header.getValue());
		            }


		            int responseCode = con.getResponseCode();
		            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
		                return readBody(con.getInputStream());
		            } else { // 에러 발생
		                return readBody(con.getErrorStream());
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


		    private static String readBody(InputStream body){
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