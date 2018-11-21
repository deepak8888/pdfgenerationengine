/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 import sandbox.*;

public class javaapplication7
{
  // public static final String IMAGE = "/home/deepak/NetBeansProjects/JavaApplication7/resources/deepak-img.JPG";
    public static final String DEST = "/home/deepak/NetBeansProjects/JavaApplication7/report.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new javaapplication7().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
       
        Font timesRomanItalic = new Font(FontFamily.TIMES_ROMAN, 20, Font.UNDERLINE);
        document.add(new Paragraph("REPORT GENERATION ENGINE ", timesRomanItalic));
        document.add(new Paragraph("\n\n\n "));
   /*     
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 5, Font.BOLD);
        PdfContentByte cb = writer.getDirectContent();
        Phrase header = new Phrase("Report of this finanacial year", ffont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    header,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);    
            
        document.open();
        document.addTitle("REPORT");
       */
        
        //ADD BACKGROUND IMAGE
    /*      PdfContentByte canvas = writer.getDirectContentUnder();
        Image image = Image.getInstance(IMAGE);
        image.scaleAbsolute(700f,700f);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);*/
        float[] columnWidths = {1, 4, 5};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
                  PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
                  cell1.setBackgroundColor(GrayColor.GRAY);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setColspan(3);
        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
     /*             PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
                  PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
                  PdfPCell cell4 = new PdfPCell(new Paragraph("Cell 4"));
                  PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
                  PdfPCell cell6 = new PdfPCell(new Paragraph("Cell 6"));
          table.addCell(cell1);
          table.addCell(cell2);
          table.addCell(cell3);
          table.addCell(cell4);
          table.addCell(cell5);
          table.addCell(cell6);*/
     table.addCell(cell1);
     for (int i = 0; i < 5; i++) {
            table.addCell("#");
            table.addCell("Key");
            table.addCell("Value");
        }
          document.add(table);
        document.close();
    }
   }

    

