/**
 * Copyright (C) 2015  Felix Eckardt, Tim Büchner
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *	Sourcecode available at: https://github.com/Felck/MOTool
 */

package utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PdfCreator {
	
	String fileName;
	Document document;
	
	public PdfCreator(String fileName) {
		this.fileName = fileName;
	}
	
	public void createPdf(){
		//create new Document
		this.document = new Document();
		
		try{
			//creation of the pdf writer with the file output name
			PdfWriter.getInstance(document, new FileOutputStream(this.fileName));
			
			//open the document so you can work with it
			document.open();
			
			//preparation of the content of the document
			Paragraph para = new Paragraph();
			para.add("This is super awesome!");
			
			//add the content to the document
			document.add(para);
			document.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	

}
