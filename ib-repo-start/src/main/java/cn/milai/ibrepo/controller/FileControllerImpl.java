package cn.milai.ibrepo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.milai.common.decoupling.Resp;
import cn.milai.ibrepo.service.FileService;

/**
 * FileController 默认实现
 * @author milai
 * @date 2020.02.01
 */
@Controller
@RequestMapping("/file")
public class FileControllerImpl implements FileController {

	private static final Logger LOG = LoggerFactory.getLogger(FileControllerImpl.class);

	@Autowired
	private FileService fileService;

	@Override
	@GetMapping("/drama")
	public void getDrama(HttpServletResponse response, String dramaCode) {
		dealFileRequest(response, dramaCode, fileService.getDrama(dramaCode));
	}

	@Override
	@GetMapping("/dramaRes")
	public void getDramaRes(HttpServletResponse response, String dramaCode) {
		dealFileRequest(response, dramaCode, fileService.getDramaRes(dramaCode));
	}

	private void dealFileRequest(HttpServletResponse response, String code, Resp<byte[]> result) {
		if (!result.isSuccess()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		try {
			response.getOutputStream().write(result.getData());
		} catch (IOException e) {
			LOG.error(String.format("返回文件失败，code = %s", code), e);
		}
	}

}
