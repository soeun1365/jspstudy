package test;

public class note {

	/*
	 	<<<웹 서버와 WAS의 차이점
		 - 웹 서버와 WAS를 구별 짓는 것은 동적 서버 콘텐츠를 수행하는가? 만약 수행한다면 WAS로 보면 된다.
		 - 웹 서버 : 정적인 HTML이나 이미지를 제공하는 서버.
		   WAS : 동적인 처리를 담당하는 서버. 
		
		<<<재사용
		누구나 사용할수있게 사용법을 알려야한다
		외부모듈과 결합도는 낮아야, 자체응집도는 높아야
		
		<<<결합도
		(결합도낮음-품질좋음)
		자료Data
		스탬프Stamp
		제어Control
		외부External
		공통Common
		내용Content
		(결합도높음-품질낮음)
		
		<<<모듈 설계작업
		- 클래스간 관계 설계
		- 비즈니스 클래스 Logic작성
		
		<<<클래스 설계서
		클래스 - 해당클래스 명칭
		패키지- 해당클래스가 속하는 패키지
		상속 - 해당클래스가 상속받는 클래스
		구현 - 해당클래스가 구현하는 클래스
		임포트 - 해당클래스가 수행하기위해 임포트해야하는 클래스
		설명 - 클래스가 수행하는 기능
		속성 - 접근제한자, 기본값, 속성설명
		
		>>> 시스템기능코드부여
		-1. 단위 시스템에 대한 명칭확인
		-2. 단위 시스템별로 대분류를 지정하여 그룹화
		-3. 단위 시스템별로 대분류를 중분류할지 여부 검토
		-4. 그룹화된 단위 시스템별로 기능코드 번호 부여
		-5. 단위 시스템별 기능 번호에 대한 중복 여부 확인 	
	 */
	
	/* 파일만들기 ********************************************** 
	 public static void main(String[] args) {
		
		//text.txt 파일 조작 객체 file 생성
		File dir = new File("C:\\MyTemp");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "text.txt");

		//text.txt 파일에 데이터 보내기
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write("안녕하세요.");
			fw.write('\n');
			fw.write("반갑습니다.");
			System.out.println(file.getAbsolutePath() + " 파일이 생성되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) {fw.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	 */
	
	/* 파일 읽기 ********************************************** 
	 	public static void main(String[] args) {
		
		File file = new File("C:\\MyTemp\\text.txt");
		try(FileReader fr = new FileReader(file)) {		//finally안해도됨
			int ch = 0;
			while((ch = fr.read())!= -1) {	//파일 내용이 끝나지않을때까지, ch에 한글자씩 읽어들인다.
				System.out.print((char)ch);	//코드값을 char로 캐스팅
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	 */
	
}
