import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

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


        for(int i=20; i<100; i+=10) {

            for(int k=0; k<10; k++) {
                for(int j=0; j<10; j++) {
                    Phrase pr = new Phrase((i+k)+" x "+(i+j)+" = ", font );
                    table.addCell(pr);
                }
            }
        }


        document.add(table);
        document.close();
    }

}
