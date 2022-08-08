package com.thelibrarian;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.thelibrarian.data.entity.BookEntity;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.*;
import java.util.List;

public class BookPDF {


    private List<BookEntity> books;

    public BookPDF(List<BookEntity> books) {
        this.books = books;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Book ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("publishedDate", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("isbn", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("description", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("imageLinks", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("pageCount", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("language", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (BookEntity book : books) {
            table.addCell(String.valueOf(book.getId_book()));
            table.addCell(String.valueOf(book.getPublishedDate()));
            table.addCell(book.getIsbn());
            table.addCell(book.getDescription());
            table.addCell(book.getImageLinks());
            table.addCell(String.valueOf(book.getPageCount()));
            table.addCell(book.getLanguage());


        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Books", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 1.5f, 1.5f, 1.5f, 1.5f,1.5f,1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }

}
