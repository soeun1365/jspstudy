package common;

public class Paging {
	public static String getPaging(String path, int totalRecord, int recordPerPage, int page) {
		//전체 페이지 수 계산
		int totalPage = totalRecord / recordPerPage;
		if(totalPage % recordPerPage != 0) {
			totalPage++;
		}
		
		//한 블록당 페이지를 5개 배치
		int pagePerBlock = 5;	//셀프로 정하는것
		
		int beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = beginPage + pagePerBlock - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		//페이징 (이전 1 2 3 4 5 다음)
		StringBuilder sb = new StringBuilder();
		//이전
		if(beginPage <= pagePerBlock) {	//첫번째 블록일 때
			sb.append("이전&nbsp;");
		}else {
			sb.append("<a href=\""+path+ "&page=" + (beginPage - 1) + "\">이전&nbsp;</a>");
		}
		//1 2 3 4 5
		for(int p = beginPage; p < endPage ; p++) {
			if(p == page) {
				sb.append(p + "&nbsp;");
			} else {
				sb.append("<a href=\""+path+ "&page=" + p + "\">" + p + "&nbsp;</a>");
			}
		}
		//다음
		if(endPage ==totalPage) {
			sb.append("다음");
		} else {
			sb.append("<a href=\""+path+ "&page=" + (endPage + 1) + "\">다음");
		}
		return sb.toString();
	}
}
