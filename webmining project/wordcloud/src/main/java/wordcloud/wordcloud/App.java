package wordcloud.wordcloud;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {
	@Autowired
	private beyonceRepository beyonceRepo;

	private String textToWordcloud = "beyonce.txt";

	@GetMapping("/beyonce")//เรียกใช้service ติดกับฟังกชันไหนเรียกใช้ฟังกชันนั้น
	
	//find all data Text
	public void wordcloud() {

		String readTextField = ""; //เก็บค่าtextที่ดึงมาจากfindall 2000 obj ต่อเป็นstringตัวเดียว

		List<beyonce> listDS = beyonceRepo.findAll();
		for (beyonce ds : listDS) { //foreachวนทั้งหมด ถ้าไม่ค่าในเบสจะไม่วนไม่ขึ้นค่าอะไรเลย
			readTextField += ds.getText();
			readTextField += " "; //บวกเว้นวรรคเพื่อใหคำเเยกออกจากกัน
		}

		//ตัดเว้นวรรคออกเเล้วใส่ในอันเรย์ เป็นคำๆ
		String[] subStr = readTextField.split(" ");
		String s = "";
        //วนคำที่ตัดเป็นอันเรย์วนทั้งหมด ตัดประโยคที่มีhttps ถ้าน้อยกว่า0ไม่มีhttpในนั้น เเต่ในที่นี้ให้ค่าเป็นน้อยกว่าเท่ากับ-1 ก็คือไม่เอาประโยคที่มีhttps
		for (String item : subStr) {
			if (item.length() > 0 && item.indexOf("https") <= -1) {
				item = positional(item);//เป็นกระบวนการที่นำคำไปตัดคำ เเปลงเรียบร้อยเเล้วเเล้วนำคำพวกนั้นมาเเทนค่าคำเดิม
				s += item; //นำคำที่ได้จาก itemที่ผ่านการตัดคำเเล้วมาต่อเป็นสตริง
			}
		}

		writeFile(s, textToWordcloud);//เขียนไฟลส่งสตริง กับ ชื่อไฟล์เข้าไป **ดูฟังกชันwritefile ก็จะได้ไฟล์ beyonce.txtออกมา
	}
	
    //ตัดอักขระพิเศษ
	private String positional(String text) {
		int s_text = text.length();
		for (int i = 0; i < s_text; i++) {
			if (!Character.isLetter(text.charAt(i)) && (!Character.isDigit(text.charAt(i)))) { //วนทุกตัวที่ส่งมาตัดอักษระพิเศษออกที่ไม่ใช่ตัวเลข0-9 กับ ตัวอักษรa-z เเทนด้วยเว้นวรรคเเทน
				text = text.substring(0, i) + ' ' + text.substring(i + 1);//ตัดอักระออกเเทนที่ด้วยเว้นวรรคของตำเเหน่งนั้น
			}
		}

		// token ทำการNFDคำให้เป็นอักษรตัวเล็กทั้งหมด เเปลงตัวอักษรที่เเปลประหลาดให้เป็นตัวเเปรปกติa-z ให้เป็นตัวปกติทั้งหมด เเล้วรีเทินคำกลับไปที่ตัวitem
		String[] list = text.split(" ");
		String word = "";
		for (String item : list) {
			word += item + " ";
		}
		return Normalizer
		        .normalize(word.toLowerCase(), Normalizer.Form.NFD)
		        .replaceAll("[^\\p{ASCII}]", "");
	}
    //เขียนไฟล์ลง.txt
	private void writeFile(String content, String writeFile) {//รับชื่อไฟล beyonce.txt
		String FILENAME = writeFile;

		BufferedWriter bw = null;//การจองพื้นที่ในการเขียนไฟลจองทีละตัว ส่งเป็นไบนารี
		FileWriter fw = null;

		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done : " + writeFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
