package com.example.filescreate;

import com.itextpdf.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.google.gson.Gson;


@SpringBootApplication
public class FilesCreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilesCreateApplication.class, args);


/*        Document document = new Document();

        try {

            //Title Commercial Invoice

            Paragraph documentTitle = new Paragraph(new Phrase("Commercial Invoice",new Font(Font.FontFamily.HELVETICA,20,Font.BOLD)));
            documentTitle.setAlignment(Element.ALIGN_CENTER);

            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);


            ArrayList<ComodityItem> commodityItemList = new ArrayList<>();
            commodityItemList.add(new ComodityItem("Balls","R530","2","630004","R600"));
            commodityItemList.add(new ComodityItem("Bats", "R730", "5", "630005", "R800"));
            commodityItemList.add(new ComodityItem("Gloves", "R330", "3", "630006", "R400"));
            commodityItemList.add(new ComodityItem("Helmets", "R930", "1", "630007", "R1000"));
            commodityItemList.add(new ComodityItem("Pads", "R430", "4", "630008", "R500"));
            commodityItemList.add(new ComodityItem("Balls","R530","2","630004","R600"));




            PdfWriter.getInstance(document, new FileOutputStream("Invoice.pdf"));
            document.open();
            document.add(documentTitle);


            PdfPTable table = new PdfPTable(2); // 2 columns

            //Size of the table
            table.setWidthPercentage(100f);
            //create top space
            table.setSpacingBefore(40.f);


            PdfPCell titleCell = new PdfPCell(new Phrase("Proforma Invoice",new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE)));
            titleCell.setBackgroundColor(BaseColor.RED);
            titleCell.setColspan(2); // This will span the title across all columns
            titleCell.setHorizontalAlignment(Element.ALIGN_CENTER); // This will align the title text to the center
            titleCell.setPadding(5f); // This will add padding inside the cell
            table.addCell(titleCell);


            PdfPCell cell1 = new PdfPCell(new Phrase("Sender",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell cell2 = new PdfPCell(new Phrase("Receiver",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(cell1);
            table.addCell(cell2);
//-------------------------------------------------Company ------------------------------------------------------------------------
            Chunk companyChunk = new Chunk("Company: ", boldFont);
            Phrase senderCompanyPhrase=new Phrase();
            senderCompanyPhrase.add(companyChunk);
            senderCompanyPhrase.add("Maziya LTD");

            PdfPCell senderCompany = new PdfPCell(senderCompanyPhrase);
            senderCompany.setPadding(4f);

            Phrase receiverCompanyPhrase=new Phrase();
            receiverCompanyPhrase.add(companyChunk);
            receiverCompanyPhrase.add("Gem-be Logistics");
            PdfPCell receiverCompany = new PdfPCell(receiverCompanyPhrase);
            receiverCompany.setPadding(4f);

            table.addCell(senderCompany);
            table.addCell(receiverCompany);


//----------------------------------------------------------Addresses-------------------------------------------------------------------------
            Chunk chunk = new Chunk("Address: ", boldFont);
            Phrase add=new Phrase();
            add.add(chunk);
            add.add("Building 13, Woodlands Office Park, 20 Woodlands Dr, Woodmead, Johannesburg, 2191");
            PdfPCell senderAddress = new PdfPCell(add);
            senderAddress.setPaddingBottom(4.f);

            Phrase rcA=new Phrase();
            rcA.add(chunk);
            rcA.add("Address: Carlos Rossi " + "Avenida JoÃO Jorge, 112, Ap. 31 " + "Vila Industrial " + "Campinas - Sp " + "13035-680");
            PdfPCell receiverAddress = new PdfPCell(rcA);
            receiverAddress.setPaddingBottom(4.f);

            table.addCell(senderAddress);
            table.addCell(receiverAddress);
 //----------------------------------------------------------NAME----------------------------------------------------------------------
            Chunk nameChunk = new Chunk("Named: ", boldFont);
            Phrase senderNamePhrase=new Phrase();
            senderNamePhrase.add(nameChunk);
            senderNamePhrase.add("Linda Justice Sibeko");

            PdfPCell senderName=new PdfPCell(senderNamePhrase);
            senderName.setPadding(4f);

            Phrase receiverNamePhrase=new Phrase();
            receiverNamePhrase.add(nameChunk);
            receiverNamePhrase.add("Gift Sizwe Sibeko");

            PdfPCell receiverName =new PdfPCell(receiverNamePhrase);
            receiverName.setPadding(4f);

            table.addCell(senderName);
            table.addCell(receiverName);
//--------------------------------------------------------Mobile-----------------------------------------------------------------------------
            Chunk mobileChunk = new Chunk("Mobile: ", boldFont);
            Phrase senderMobilePhrase=new Phrase();
            senderMobilePhrase.add(mobileChunk);
            senderMobilePhrase.add("(+27) 82 280 7214");


            PdfPCell senderMobile =new PdfPCell(senderMobilePhrase);
            senderMobile.setPadding(4f);

            Phrase receiverMobilePhrase=new Phrase();
            receiverMobilePhrase.add(mobileChunk);
            receiverMobilePhrase.add("(+457) 82 28 14");

            PdfPCell  receiverMobile=new PdfPCell(receiverMobilePhrase);
            receiverMobile.setPadding(4f);

            table.addCell(senderMobile);
            table.addCell(receiverMobile);
//--------------------------------------------------------------Export Code------------------------------------------------------------------
            Chunk exportCodeChunk = new Chunk("Export Code: ", boldFont);
            Phrase exportCodePhrase=new Phrase();
            exportCodePhrase.add(exportCodeChunk);
            exportCodePhrase.add("0103045390087");

            PdfPCell exportCode = new PdfPCell(exportCodePhrase);
            exportCode.setPadding(4f);
//----------------------------------------------------------Country----------------------------------------------------------------------------------
            Chunk countryChunk = new Chunk("Country: ", boldFont);
            Phrase countryPhrase=new Phrase();
            countryPhrase.add(countryChunk);
            countryPhrase.add("Brazil");

            PdfPCell country=new PdfPCell(countryPhrase);
            country.setPadding(4f);

            table.addCell(exportCode);
            table.addCell(country);
//--------------------------------------------------------------DONE -------------------------------------------------------------------------


            document.add(table);

            //Add the second Table
            PdfPTable table2 = new PdfPTable(6); // 5 columns


            table2.setWidthPercentage(100f);
            //create top space
            table2.setSpacingBefore(40.f);

            // Set relative column widths
            float[] columnWidths = {1.7f, 1f, 0.5f, 1f, 1f,1f}; // Make the "Item" column twice as large as the others
            table2.setWidths(columnWidths);



            PdfPCell itemTitle = new PdfPCell(new Phrase("Commodity Table",new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE)));
            itemTitle.setBackgroundColor(BaseColor.RED);
            itemTitle.setColspan(6); // This will span the title across all columns
            itemTitle.setHorizontalAlignment(Element.ALIGN_CENTER); // This will align the title text to the center
            itemTitle.setPadding(5f); // This will add padding inside the cell

            table2.addCell(itemTitle);

            PdfPCell item = new PdfPCell(new Phrase("Item", new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell unitPrice =new PdfPCell(new Phrase("Price (ZAR)",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell qty =new PdfPCell(new Phrase("Qty",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell hs_code=new PdfPCell(new Phrase("Hs code",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell tax_and_duties=new PdfPCell(new Phrase("Tax ",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell duties=new PdfPCell(new Phrase("Duties",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));

            item.setPadding(5f);
            unitPrice.setPadding(5f);
            qty.setPadding(5f);
            hs_code.setPadding(5f);
            tax_and_duties.setPadding(5f);



            table2.addCell(item);
            table2.addCell(unitPrice);
            table2.addCell(qty);
            table2.addCell(hs_code);
            table2.addCell(tax_and_duties);
            table2.addCell(duties);

            for (ComodityItem comodityItem : commodityItemList)
            {
                PdfPCell itemData  = new PdfPCell(new Phrase(comodityItem.getItem()));
                PdfPCell itemUnityPrice  = new PdfPCell(new Phrase(comodityItem.getPrice()));
                PdfPCell qtyItem  = new PdfPCell(new Phrase(comodityItem.getQty()));
                PdfPCell hs_code_item = new PdfPCell(new Phrase(comodityItem.getHs_code()));
                PdfPCell tax_and_duties_item  = new PdfPCell(new Phrase(comodityItem.getTax_duties()));
                PdfPCell duties_item  = new PdfPCell(new Phrase(comodityItem.getTax_duties()));

                itemData.setPadding(5f);
                itemUnityPrice.setPadding(5f);
                qtyItem.setPadding(5f);
                hs_code_item.setPadding(5f);
                tax_and_duties.setPadding(5f);
                duties_item.setPadding(5f);


                table2.addCell(itemData);
                table2.addCell(itemUnityPrice);
                table2.addCell(qtyItem);
                table2.addCell(hs_code_item);
                table2.addCell(tax_and_duties_item);
                table2.addCell(duties_item);


            }



            PdfPCell totals_hide  = new PdfPCell(new Phrase(""));
            totals_hide.setColspan(3);
            totals_hide.setBorder(Rectangle.NO_BORDER);
            table2.addCell(totals_hide);

            Chunk totals_chunk = new Chunk("Total ", boldFont);
            Phrase totals_Phrase=new Phrase();
            totals_Phrase.add(totals_chunk);

            PdfPCell totals  = new PdfPCell(totals_Phrase);

            totals.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totals.setPadding(5f);

            table2.addCell(totals);


            PdfPCell totals_tax  = new PdfPCell(new Phrase("R2500"));
            totals_tax.setPadding(5f);
            table2.addCell(totals_tax);

            PdfPCell totals_duties  = new PdfPCell(new Phrase("R4500"));
            totals_tax.setPadding(5f);
            table2.addCell(totals_duties);



            PdfPCell jumper  = new PdfPCell(new Phrase(""));
            jumper.setBorder(Rectangle.NO_BORDER);
            jumper.setColspan(6);
            jumper.setPadding(15f);
            table2.addCell(jumper);






            PdfPCell total_tax_dutie_4  = new PdfPCell(new Phrase("Tax and Duties",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell total_tax_duties  = new PdfPCell(new Phrase("R100",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell total_hide =new PdfPCell(new Phrase(""));

            total_tax_dutie_4.setColspan(2);
            total_tax_duties.setPadding(5f);
            total_hide.setColspan(3);
            total_hide.setBorder(Rectangle.NO_BORDER);


            ///


            table2.addCell(total_hide);
             table2.addCell(total_tax_dutie_4);
             table2.addCell(total_tax_duties);



            //Admin


            PdfPCell admin_fee_4 = new PdfPCell(new Phrase("Admin Fees",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell admin_fee  = new PdfPCell(new Phrase("R1000",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell admin_fee_hide =new PdfPCell(new Phrase(""));

            admin_fee_hide.setColspan(3);
            admin_fee_hide.setBorder(Rectangle.NO_BORDER);

            admin_fee_4.setColspan(2);
            admin_fee.setPadding(5f);

            table2.addCell(admin_fee_hide);
            table2.addCell(admin_fee_4);
            table2.addCell(admin_fee );



            ///Total
            PdfPCell total_4 = new PdfPCell(new Phrase("Total",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell total  = new PdfPCell(new Phrase("R10000",new Font(Font.FontFamily.HELVETICA,12,Font.BOLD)));
            PdfPCell total_hide_4 =new PdfPCell(new Phrase(""));


            total_hide_4.setColspan(3);
            total_hide_4.setBorder(Rectangle.NO_BORDER);


            total_4.setColspan(2);
            total.setPadding(5f);




            table2.addCell(total_hide_4);
            table2.addCell(total_4);
            table2.addCell(total);




        document.add(table2);

        document.close();


        System.out.println("PDF Created!");
    } catch (DocumentException | IOException | FileNotFoundException e) {
        e.printStackTrace();
    } catch (java.io.IOException e) {
        throw new RuntimeException(e);
    }*/

 /* int numCells = 4;


            DecimalFormat df = new DecimalFormat("####0.00");

            Image logo = Image.getInstance(getApplicationProperties().emailPath()+"img.png");//logo.png
            logo.setAlignment(Element.ALIGN_LEFT);
            logo.scaleToFit(130, 40);
            document.add(logo);

            PdfPTable table = new PdfPTable(numCells);
            // Set table Width as 100%
            table.setWidthPercentage(100f);
            //create top space
            table.setSpacingBefore(100.f);
            float[] columnWidths = { 1f, 5f,1f,1f };// Second column will be twice as big

            PdfPCell cell = new PdfPCell(new Phrase("Commercial Invoice"));
            cell.setColspan(numCells);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            int headingCells = numCells / 2;
            float padding = 4.f;

            PdfPCell senderHeading=new PdfPCell(new Phrase("Sender:"));
            senderHeading.setColspan(headingCells);
            senderHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
            senderHeading.setPadding(padding);

            PdfPCell receiverHeading=new PdfPCell(new Phrase("Receiver:"));
            receiverHeading.setColspan(headingCells);
            receiverHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
            receiverHeading.setPadding(padding);

            table.addCell(senderHeading);
            table.addCell(receiverHeading);

            //Sender details
            String senderCompanyName = (proformaInvoiceDTO.sender.companyName != null && !proformaInvoiceDTO.sender.companyName.isEmpty()) ? proformaInvoiceDTO.sender.companyName : "Company: N/A";
            PdfPCell SenderCompanyName = new PdfPCell(new Phrase(senderCompanyName));
            SenderCompanyName.setColspan(headingCells);
            SenderCompanyName.setPadding(padding);
            ;

            PdfPCell SenderAddress = new PdfPCell(new Phrase(String.format("%s, %s, %s", proformaInvoiceDTO.sender.companyAddress, booking.getFromSuburb(), booking.getPickUpPCode())));
            SenderAddress.setColspan(headingCells);
            SenderAddress.setPadding(padding);

            PdfPCell SenderName = new PdfPCell(new Phrase("Sender Name: " + proformaInvoiceDTO.sender.name));
            SenderName.setColspan(headingCells);
            SenderName.setPadding(padding);

            PdfPCell SenderContactNum = new PdfPCell(new Phrase("Sender Contact: " + proformaInvoiceDTO.sender.contact));
            SenderContactNum.setColspan(headingCells);
            SenderContactNum.setPadding(padding);

            PdfPCell SenderExportCode = new PdfPCell(new Phrase("Export code: " + proformaInvoiceDTO.exportCode));//code or Id number
            SenderExportCode.setColspan(headingCells);
            SenderExportCode.setPadding(padding);

            //receiver details
            String receiverCName = (proformaInvoiceDTO.receiver.companyName != null && !proformaInvoiceDTO.receiver.companyName.isEmpty()) ? proformaInvoiceDTO.receiver.companyName : "Company: N/A";
            PdfPCell receiverCompanyName = new PdfPCell(new Phrase(receiverCName));
            receiverCompanyName.setColspan(headingCells);
            receiverCompanyName.setPadding(padding);

            PdfPCell receiverAddress = new PdfPCell(new Phrase(String.format("Address: %s, %s %s, %s", proformaInvoiceDTO.receiver.companyAddress, booking.getDropOffPerson().getState() != null ? booking.getDropOffPerson().getState() : booking.getToSuburb(), booking.getDropOffPerson().getSuburb() != null ? "," + booking.getDropOffPerson().getSuburb() : "", booking.getDropOffPerson().getZip() != null ? booking.getDropOffPerson().getZip() : booking.getDropOffzip())));
            receiverAddress.setColspan(headingCells);
            receiverAddress.setPadding(padding);

            PdfPCell receiverName = new PdfPCell(new Phrase("Receiver Name: " + proformaInvoiceDTO.receiver.name));
            receiverName.setColspan(headingCells);
            receiverName.setPadding(padding);

            PdfPCell receiverContactNum = new PdfPCell(new Phrase("Receiver Contact: " + proformaInvoiceDTO.receiver.contact));
            receiverContactNum.setColspan(headingCells);
            receiverContactNum.setPadding(padding);

            PdfPCell receiverExportCode=new PdfPCell(new Phrase(""));//code or Id number
            receiverExportCode.setColspan(headingCells);
            receiverExportCode.setPadding(padding);

            table.addCell(SenderCompanyName);
            table.addCell(receiverCompanyName);

            table.addCell(SenderAddress);
            table.addCell(receiverAddress);

            table.addCell(SenderName);
            table.addCell(receiverName);

            table.addCell(SenderContactNum);
            table.addCell(receiverContactNum);

            table.addCell(SenderExportCode);
            table.addCell(receiverExportCode);

            PdfPCell qtyHeader=new PdfPCell(new Phrase("QTY"));
            PdfPCell commodityHeader=new PdfPCell(new Phrase("Commodity"));
            PdfPCell unitPriceHeader=new PdfPCell(new Phrase("Unit Price"));
            PdfPCell amountHeader=new PdfPCell(new Phrase("Amount"));

            table.addCell(qtyHeader);
            table.addCell(commodityHeader);
            table.addCell(unitPriceHeader);
            table.addCell(amountHeader);
            double totalAmt=0.0;
            //Todo for loop
            for(ProformaCommodity c:proformaInvoiceDTO.commodities){
                PdfPCell qty=new PdfPCell(new Phrase(String.valueOf(c.qty)));
                PdfPCell commodity = new PdfPCell(new Phrase(c.name));
                PdfPCell unitPrice = new PdfPCell(new Phrase("R" + String.valueOf(c.unitPrice)));
                PdfPCell amount = new PdfPCell(new Phrase("R" + df.format(c.amount)));

                totalAmt=totalAmt+c.amount;

                table.addCell(qty);
                table.addCell(commodity);
                table.addCell(unitPrice);
                table.addCell(amount);

            }


            PdfPCell totalTxt=new PdfPCell(new Phrase("Total"));
            totalTxt.setColspan(headingCells);
            totalTxt.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalTxt.setPadding(padding);


            PdfPCell total=new PdfPCell(new Phrase("R"+df.format(totalAmt)));
            total.setColspan(headingCells);
            receiverHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
            receiverHeading.setPadding(padding);

            table.addCell(totalTxt);
            table.addCell(total);


            document.add(table);
            document.close();
            log.info("complete........");*/


        String skynetBaseURL="https://uat.skynet.co.za:3227/api/";
        String url=skynetBaseURL+"Security/GetSecurityToken";
        TokenRequest request=new TokenRequest();
        request.SystemId="";
        request.Password="";
        request.UserName="";

        String response= WebClient.create(url)
                .post()
                .body(Mono.just(request),TokenRequest.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        TokenResponse res=new Gson().fromJson(response,TokenResponse.class);




        SkynetQouteRequest skynetQouteRequest = new SkynetQouteRequest();
        ParcelDims p = new ParcelDims();
        p.parcel_description= "box";
        p.parcel_number = "2";
        p.parcel_height =2;
        p.parcel_breadth = 2;
        p.parcel_length = 2;
        p.parcel_mass = 2;
        List<ParcelDims> list= new ArrayList<>();
        list.add(p);

        skynetQouteRequest.parcelList = list;
        skynetQouteRequest.securityToken =res.getSecurityToken();
        skynetQouteRequest.accountNumber = "";
        skynetQouteRequest.fromCity = "Woodmead";
        skynetQouteRequest.fromCityPostalCode = "2191";
        skynetQouteRequest.toCity = "ERAND";
        skynetQouteRequest.toCityPostalCode = "1685";
        skynetQouteRequest.serviceType = "ON1";



        String newUrl = skynetBaseURL+"Financial/GetQuote";

        System.out.println(new Gson().toJson(skynetQouteRequest));
        String responseQ = WebClient.create(newUrl)
                .post()
                .body(Mono.just(skynetQouteRequest),SkynetQouteRequest.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responseQ);









    }

}
