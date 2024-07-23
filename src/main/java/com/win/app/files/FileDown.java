package com.win.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

//		Iterator<String> keys = model.keySet().iterator();
//
//		while (keys.hasNext()) {
//			String k = keys.next();
//		}

		FileDTO fileDTO = (FileDTO) model.get("file");
		String directory = (String) model.get("board");

		// 1.폴더 경로 준비
		String path = request.getSession().getServletContext().getRealPath("/resources/upload/" + directory);

		// 2.파일 준비
		File file = new File(path, fileDTO.getFileName());

		// 3.응답시 인코딩 처리(filter로 처리했으면 선택)
		response.setCharacterEncoding("UTF-8");

		// 4.파일의 크기 지정
		response.setContentLength((int) file.length());

		// 5.다운로드시 파일이름 지정, 인코딩설정
		String name = fileDTO.getOriName();
		name = URLEncoder.encode(name, "UTF-8");

		// 6.Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + name + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");

		// 7.클라이언트 전송

		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(fi, os);

		// 8.해제
		os.close();
		fi.close();

		System.out.println("Flie Down View");

	}
}
