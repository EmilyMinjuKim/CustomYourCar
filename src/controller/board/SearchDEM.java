package controller.board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchDEM {

    static List<File> targetFiles = null;

    static String baseDir = "E:\\document\\LKC_Workspace\\JAVA\\Soldesk_Car_plusNotice\\BoardDetail";    //�˻��� ���丮
    static String word;         //�˻��Ҵܾ,�� �����ؼ� ����
    static String save = "E:\\document\\LKC_Workspace\\JAVA\\Soldesk_Car_plusNotice\\searchresult";       //�˻������ ����� ���ϸ�
                                                                                         // ���� ��ġ�� �̸� ����� �μž� �մϴ�. 
                                                                                         // mkdir -p ������ġ
    public static void main( String[] args ) throws Exception
    {

    	Scanner scan = new Scanner(System.in);
    	System.out.print("�˻��� �ܾ� �Է� : ");
    	word = scan.next();
    	
        File Dir = new File(baseDir);
        File[] Files = Dir.listFiles();
        
        /*
        for (int i = 0; i < Files.length; i++) { 
        	System.out.println("file: " + Files[i]);
        }
   		 */

        //�о���� ���� input stream ����
        BufferedReader br = null;
        String[] words = word.split(",");
        
        for(int i = 0; i < Files.length; i++){

        	//������ �ƴ� ��� continue
            if(!Files[i].isFile()) {
                continue;
            }

            //input stream object ����
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Files[i]), "utf-8"));
            String line = "";
            //System.out.println("������ ����??" + br.readLine());
       

          //������ ���� output stream ����
          //PrintWriter writer = new PrintWriter(new FileWriter(save + "\\" + "result" + ".txt"));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(save + "\\" + "result" + ".txt", true), "utf-8"));
            
            //�� ������ �� ���ξ� �о���δ�.
            while((line = br.readLine()) != null) {
            	
            	//���� ������ �˻��ϰ���  �ܾ �ϳ��� ������ ���Ͽ� ����Ѵ�.
                for(int j=0; j<words.length;j++)
                if(line.indexOf(words[j]) != -1) {
                    //writer.write(word + "=" + Files[i].getAbsolutePath());
                    System.out.println(line);
                    writer.write(line.trim() + "\n");
                }
            }
            
            writer.flush();

            //input stream close.
            br.close();

            //output stream close.
            writer.close();
        }

    }

}
