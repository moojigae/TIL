package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		// 파일이름 들어오는걸 이름 다 바꿔줌
		// 시간과 랜덤숫자 사용
		long currentTime = System.currentTimeMillis();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmss");
		int ranNum = (int)(Math.random() * 100000);
		
		String name = originFile.getName();
		int dot = name.lastIndexOf(".");
		
		String ext = null;
		if(dot != -1) {
			ext = name.substring(dot);
		} else {
			ext = ""; 
		}
		
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext;
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
