package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		// 현재시간 가져오기
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		// 랜덤값
		int ranNum = (int)(Math.random() * 100000);
		
		// 확장자명 가져오기
		String name = originFile.getName();
		int dot = name.lastIndexOf(".");
		
		String ext = null;
		if(dot != -1) {
			ext = name.substring(dot);
		} else {
			ext = "";
		}
		
		// 새롭게 만들 파일 이름
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext;
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
