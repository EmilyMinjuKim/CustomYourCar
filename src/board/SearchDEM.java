/* SBS 1차 팀 프로젝트
 * 게시판 파트 - 텍스트 파일을 원하는 리스트로 생성하는 클래스
 * 작성자 : 이경철, 정유진
 * 최종 수정일 : 2021.12.30
 */

// 원래 목적은 디렉토리 파일 전부를 검색하여 출력할 예정이였으나
// 계획을 변경하여 한 파일만 검색하게 수정.
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

    static String Dir = "NoticeDTO.txt";    //검색할 파일
    static String word;         //검색할단어를,로 구분해서 나열
    static String save = "searchresult";       //검색결과가 저장될 파일명
    
    JScrollPane jsp;
                          
        public SearchDEM(String word) throws IOException, Exception {   

    	System.out.print("검색할 단어 입력 : ");
    	this.word = word;
    
        //읽어들일 파일 input stream 선언
        BufferedReader br = null;
        String[] words = word.split(",");
        

            //input stream object 생성
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Dir), "utf-8"));
            
            //검색결과를 저장. 검색할때마다 같은 파일을 갱신함.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(save + "\\" + "result" + ".txt"), "utf-8"));
            
            //각 파일의 한 라인씩 읽어들인다.
            while((line = br.readLine()) != null) {
            	
            	//라인 내용중 검색하고자  단어가 하나라도 있으면 파일에 기록한다.
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
            
            this.jsp = mt.scrolledTable;	//해당 타입의 테이블을 리턴
            

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

