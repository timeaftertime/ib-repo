package cn.milai.ib.repo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.milai.ib.repo.model.Response;
import cn.milai.ib.repo.service.FileService;
import lombok.extern.slf4j.Slf4j;

/**
 * FileController 默认实现
 * @author milai
 * @date 2020.02.01
 */
@Slf4j
@Controller
@RequestMapping("/file")
public class FileControllerImpl implements FileController {

	@Autowired
	private FileService fileService;

	@Override
	@GetMapping("/img")
	public void getCharacterImage(HttpServletResponse response, String characterCode, String status) {
		if (status == null) {
			status = "";
		}
		dealFileRequest(response, characterCode, fileService.getCharacterImage(characterCode, status));
	}

	@Override
	@GetMapping("/conf")
	public void getCharacterConf(HttpServletResponse response, String characterCode) {
		dealFileRequest(response, characterCode, fileService.getCharacterConf(characterCode));
	}

	@Override
	@GetMapping("/drama")
	public void getDrama(HttpServletResponse response, String dramaCode) {
		dealFileRequest(response, dramaCode, fileService.getDrama(dramaCode));
	}

	private void dealFileRequest(HttpServletResponse response, String code, Response<byte[]> result) {
		if (!result.isSuccess()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		try {
			response.getOutputStream().write(result.getData());
		} catch (IOException e) {
			log.error(String.format("返回文件失败，code = %s", code), e);
		}
	}

}
