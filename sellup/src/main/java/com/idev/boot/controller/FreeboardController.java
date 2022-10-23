package  com.idev.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idev.boot.dto.TimelineBoardComments;
import com.idev.boot.dto.PageDto;
import com.idev.boot.dto.TimelineBoard;
import com.idev.boot.service.CommentService;
import com.idev.boot.service.FreeboardService;


@Controller
@RequestMapping("/community")    //-> view 폴더명 동일할때 생략, 리다이렉트 community 생략
public class FreeboardController {
	private static final Logger logger = LoggerFactory.getLogger(FreeboardController.class);
	
	@Autowired
	private FreeboardService service;
	
	@Autowired
	private CommentService  cmtservice;
	
	
//   request mapping을 여러 url 요청으로 할수 있습니다.value 가 배열.
	//게시판 리스트 보기(검색기능 포함)     	
	@RequestMapping(value={"/","/list"})   
	public String pageList(PageDto param,Model model) { //String page,String field,String findText,Model model) {
		
		List<TimelineBoard> list;
		if(param==null) param=new PageDto();
		if(param.getPage()==0) param.setPage(1) ;
		
		//page를 사용자 맘대로 문자 대입하면 NumberFormatExceptrion 발생 -> ExceptionHandler 로 처리합니다.
		//검색 기능사용할 때 검색필드와 검색키워드 뷰에 전달한다.
		list=service.getPagelist();  
		Map<String,Object> map = new HashMap<String,Object>();    
		map.put("list",list);				//          "
		model.addAllAttributes(map);	//위에 4개의 put 실행한 map객체를 애트리뷰트에 저장한다.
		
		return "community/list";
		
	} 
	@RequestMapping("/cookie")
	public String cookie(HttpServletRequest req, Model model) {
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("read")) {
				logger.info(c.getName());
				logger.info(c.getValue());
				String [] s = c.getValue().split("/");
				model.addAttribute("list", s);
			}
		}
		return "community/cookie";    
		}
	
	
	//상세보기 : 
	@RequestMapping("/detail")     
//	public void detail(int idx, int page,String field, String findText, Model model) {     //쿠키로 조회수 카운트 구현하기 이전
	public String detail(int idx, int page,String field, Model model) { 
	
		model.addAttribute("bean",service.getBoardOne(idx) );
		model.addAttribute("cmtlist",cmtservice.commentList(idx) );
		model.addAttribute("cr","\n" );
		model.addAttribute("field",field);

		//view는 community/detail
		return "community/detail";
	}
	
	//글쓰기 - view  : insert() 메소드 
	@RequestMapping(value="/insert")
	public void insert(@RequestParam(defaultValue = "1") int page,Model model) {
		//로그인 되었을때만 글쓰기
		model.addAttribute("page", page);
	}  //view이름은 insert
	
	
	
	//글쓰기 - 저장   : save()메소드  리다이렉트 list로.
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute TimelineBoard board) {   
		service.insert(board);
		return "redirect:list";

	}
	
	//수정 화면 출력
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(@RequestParam Map<String, String> param,Model model) {		//@RequestParam Map<String, String> param
		//로그인 되었을때만
		model.addAttribute("bean", service.getBoardOne(Integer.parseInt(param.get("idx"))));
		model.addAllAttributes(param);
		logger.info(param.toString());			//파라미터 이름 확인하세요.-idx,page,field,findText
		//model.addAttribute("page", param.get("page"));
	}
	//참고
	@ExceptionHandler(NumberFormatException.class)		//Exception 지정하여 오류가 생기면 이동하는 페이지 설정합니다.
	public ModelAndView handleErr(HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();			//model과 view를 저장하는 객체
		mav.addObject("url", request.getRequestURL());   //애트리뷰트 저장
		mav.setViewName("/error/error");
		return mav;
	}
	
	
	
}
