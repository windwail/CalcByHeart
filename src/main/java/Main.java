import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    private static Font font = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);


    public static void main(String[] args) throws Exception {
        Document document = new Document();
        document.setPageSize(PageSize.A4);
        document.setMargins(14,14, 20,20);
        PdfWriter.getInstance(document, new FileOutputStream("PDFFILE.pdf"));
        document.open();
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);


        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i=20; i<100; i+=10) {

            for(int k=0; k<10; k++) {
                for(int j=0; j<10; j++) {
                    list.add(new Integer[] { i+k, i+j});
                }
            }
        }

        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);

        Iterator<Integer[]> iterator = list.iterator();

        for(int i=20; i<100; i+=10) {

            for(int k=0; k<10; k++) {
                for(int j=0; j<10; j++) {
                    Integer[] rec = iterator.next();

                    Phrase pr = new Phrase(rec[0]+" x "+rec[1]+" = ", font );
                    table.addCell(pr);
                }
            }
        }


        document.add(table);
        document.close();
    }

}
