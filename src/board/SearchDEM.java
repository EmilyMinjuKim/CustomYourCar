/* SBS 1�� �� ������Ʈ
 * �Խ��� ��Ʈ - �ؽ�Ʈ ������ ���ϴ� ����Ʈ�� �����ϴ� Ŭ����
 * �ۼ��� : �̰�ö, ������
 * ���� ������ : 2021.12.30
 */

// ���� ������ ���丮 ���� ���θ� �˻��Ͽ� ����� �����̿�����
// ��ȹ�� �����Ͽ� �� ���ϸ� �˻��ϰ� ����.
package board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JScrollPane;

public class SearchDEM {

    static List<File> targetFiles = null;
    
    String line = "";

    static String Dir = "NoticeDTO.txt";    //�˻��� ����
    static String word;         //�˻��Ҵܾ,�� �����ؼ� ����
    static String save = "searchresult";       //�˻������ ����� ���ϸ�
    
    JScrollPane jsp;
                          
        public SearchDEM(String word) throws IOException, Exception {   

    	System.out.print("�˻��� �ܾ� �Է� : ");
    	this.word = word;
    
        //�о���� ���� input stream ����
        BufferedReader br = null;
        String[] words = word.split(",");
        

            //input stream object ����
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Dir), "utf-8"));
            
            //�˻������ ����. �˻��Ҷ����� ���� ������ ������.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(save + "\\" + "result" + ".txt"), "utf-8"));
            
            //�� ������ �� ���ξ� �о���δ�.
            while((line = br.readLine()) != null) {
            	
            	//���� ������ �˻��ϰ���  �ܾ �ϳ��� ������ ���Ͽ� ����Ѵ�.
                for(int j=0; j<words.length;j++)
                if(line.indexOf(words[j]) != -1) {
                    System.out.println(line);
                    writer.write(line.trim() + "\n");
                }
            }
            
            writer.flush();

            //input stream close.
            br.close();

            //output stream close.
            writer.close();
            MyTable mt = new MyTable(save + "\\" + "result" + ".txt");
            
            this.jsp = mt.scrolledTable;	//�ش� Ÿ���� ���̺��� ����
            

        }


		public static String getWord() {
			return word;
		}


		public static void setWord(String word) {
			SearchDEM.word = word;
		}


		public JScrollPane getJsp() {
			return jsp;
		}


		public void setJsp(JScrollPane jsp) {
			this.jsp = jsp;
		}

    }

