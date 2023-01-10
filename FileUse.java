package FileUse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUse {
	static File F=new File("data1.txt");
	public static void main(String [] args) throws IOException
	{
		
	}
	public void FileUse() throws IOException {
		if(F.exists())//开启前清空上过一次的计算结果
		{
			 FileWriter fw = new FileWriter(F);
		     BufferedWriter bw = new BufferedWriter(fw);
	         fw.write("");
	         fw.flush();
	         fw.close();
		}
		else
		{
			try{
				F.createNewFile();
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("不存在");
		}
	}
}
