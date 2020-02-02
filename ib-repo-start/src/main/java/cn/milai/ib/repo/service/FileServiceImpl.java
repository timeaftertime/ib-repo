package cn.milai.ib.repo.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.milai.ib.repo.model.Response;
import cn.milai.ib.repo.model.ResponseCode;
import cn.milai.ib.repo.util.ValidUtil;

/**
 * FileService 默认实现
 * @author milai
 * @date 2020.02.01
 */
@Service
public class FileServiceImpl implements FileService {

	@Value("${file.img.path}")
	private String imgBasePath;
	@Value("${file.conf.path}")
	private String confBasePath;
	@Value("${file.drama.path}")
	private String dramaBasePath;

	private static final String IMG_SUFFIX = ".gif";
	private static final String CONF_SUFFIX = ".conf";
	private static final String DRAMA_SUFFIX = ".drama";

	private static final String IMG_STATUS_SPLIT = "$";

	@Override
	public Response<byte[]> getCharacterImage(String characterCode, String status) {
		ValidUtil.resourceId(characterCode);
		if (!status.equals("")) {
			status = IMG_STATUS_SPLIT + status;
		}
		return dealFileRequest(imgBasePath + idToPath(characterCode) + status + IMG_SUFFIX);
	}

	@Override
	public Response<byte[]> getCharacterConf(String characterCode) {
		ValidUtil.resourceId(characterCode);
		return dealFileRequest(confBasePath + idToPath(characterCode) + CONF_SUFFIX);
	}

	@Override
	public Response<byte[]> getDrama(String dramaCode) {
		ValidUtil.resourceId(dramaCode);
		return dealFileRequest(dramaBasePath + idToPath(dramaCode) + DRAMA_SUFFIX);
	}

	private static String idToPath(String id) {
		return id.replace('.', '/');
	}

	private Response<byte[]> dealFileRequest(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return Response.fail(ResponseCode.RESOURCE_FILE_NOT_FOUND, fileName);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			InputStream in = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			in.close();
		} catch (IOException e) {
			Response.fail(ResponseCode.READ_RESOURCE_FILE_FAILED, fileName);
		}
		return Response.success(out.toByteArray());
	}

}
