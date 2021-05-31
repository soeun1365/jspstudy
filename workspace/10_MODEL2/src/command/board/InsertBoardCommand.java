package command.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부파일이 저장될 디렉터리
		final String DIRECTORY = "archive";
		
		String realPath = request.getServletContext().getRealPath(DIRECTORY);//실제 경로 알아내기
		File dir = new File(realPath);	//리얼패스에 파일을 만드는 dir
		if(!dir.exists()) {
			dir.mkdirs();	//폴더 없으면 만들어라
		}
		ModelAndView mav = null;
		// 파라미터 처리: MultipartRequest가 담당
		MultipartRequest multipartRequest = null;
		try {
			// 업로드 진행
			multipartRequest = new MultipartRequest(request,
													realPath,
													1024 * 1024 * 10,
													"utf-8",
													new DefaultFileRenamePolicy());
			//파라미터 처리 : MultipartRequest가 담당
			String author = multipartRequest.getParameter("author");
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			String ip = multipartRequest.getParameter("ip");
			String filename = null;
			if (multipartRequest.getFile("filename") == null ) {
				filename = "";
			} else {
				filename = multipartRequest.getFilesystemName("filename");	//getFilesystemName: 저장될 때 이름
			}
			//DB로 보낼 DTO
			BoardDTO dto = new BoardDTO();
			dto.setAuthor(author);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setFilename(filename);
			dto.setIp(ip);
			// DAO의 insertBoard()메소드 호출
			int result = BoardDAO.getInstance().insertBoard(dto);
			if(result == 0) {	//실패했을경우
				PrintWriter out = response.getWriter();
				out.println("<sctipt>");
				out.println("alert('게시글이 저장되지 않았습니다.')");
				out.println("history.back()");
				out.println("</sctipt>");
			} else {	//성공했을 경우
				mav = new ModelAndView("/10_MODEL2/selectListBoardPage.b", true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
