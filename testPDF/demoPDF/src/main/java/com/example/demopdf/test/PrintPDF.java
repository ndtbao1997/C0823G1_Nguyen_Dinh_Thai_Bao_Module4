package com.example.demopdf.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PrintPDF {
    public static void printPDF(){
        float customWidth = 200;
        float customHeight = 225;
        Rectangle pageSize = new Rectangle(customWidth, customHeight);
        Document document = new Document(pageSize, 10, 10, 10, 10);

        try {

            // Tạo đối tượng PdfWriter
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("D:\\C0823G1_Nguyen_Dinh_Thai_Bao_Module1\\module_4\\testPDF\\demoPDF\\src\\main\\java\\com\\example\\demopdf\\test\\viblo_asia.pdf"));
            document.open();
            PdfContentByte contentByte = pdfWriter.getDirectContentUnder();
            Image backgroundImage = Image.getInstance("D:\\C0823G1_Nguyen_Dinh_Thai_Bao_Module1\\module_4\\testPDF\\demoPDF\\src\\main\\java\\com\\example\\demopdf\\test\\pngtree-black-minimalist-atmospheric-wooden-background-backgroundwooden-backgroundtree-texture-image_77053.jpg");
            backgroundImage.setAbsolutePosition(0, 0);
            contentByte.addImage(backgroundImage);

            // Mở file để thực hiện ghi


            // Thêm nội dung sử dụng add function
            BaseFont baseFont = BaseFont.createFont("D:\\C0823G1_Nguyen_Dinh_Thai_Bao_Module1\\module_4\\testPDF\\demoPDF\\src\\main\\java\\com\\example\\demopdf\\test\\arial-unicode-ms.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 15, Font.BOLD, BaseColor.YELLOW);

            Chunk chunk = new Chunk("Vé xe nhà xe Hiếu Hoa", font);
            Paragraph paragraph = new Paragraph(chunk);

            document.add(paragraph);
            Font font1 = new Font(baseFont, 12, Font.BOLD, BaseColor.WHITE);

            Chunk chunk1 = new Chunk("Điểm đi: Huế", font1);
            Paragraph paragraph1 = new Paragraph(chunk1);
            Chunk chunk6 = new Chunk("Điểm đến: Đà nẵng", font1);
            Paragraph paragraph6 = new Paragraph(chunk6);
            document.add(paragraph1);
            document.add(paragraph6);
            Font font2 = new Font(baseFont, 10, Font.NORMAL, BaseColor.WHITE);

            Chunk chunk2 = new Chunk("Thời gian đi: 11:22:33 11/22/2024", font2);
            Paragraph paragraph2 = new Paragraph(chunk2);

            document.add(paragraph2);

            Chunk chunk3 = new Chunk("Thời gian đến: 11:22:33 11/22/2024", font2);
            Paragraph paragraph3 = new Paragraph(chunk3);

            document.add(paragraph3);
            Chunk chunk4 = new Chunk("Số ghế: ", font2);
            Paragraph paragraph4 = new Paragraph(chunk4);

            document.add(paragraph4);
            Chunk chunk5 = new Chunk("Trạng thái: Đã thanh toán", font2);
            Paragraph paragraph5 = new Paragraph(chunk5);

            document.add(paragraph5);
            document.add(new Paragraph(""));
            Image image1 = Image.getInstance("D:\\C0823G1_Nguyen_Dinh_Thai_Bao_Module1\\module_4\\testPDF\\demoPDF\\src\\main\\java\\com\\example\\demopdf\\test\\hieuhoa_logo_trang.png");
            image1.scaleAbsoluteWidth(180);
            document.add(image1);


            // Đóng File
            document.close();
            System.out.println("Write file succes!");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
