import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderFromFolder {

	@Test
	public void readPDFTest() throws IOException {

		URL url = new URL("file:///C:/Users/welcome/Downloads/employee-information-form-download-20170810.pdf");

		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;

		document = PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);

		Assert.assertTrue(pdfContent.contains("Company Name"));
		Assert.assertTrue(pdfContent.contains("Employee Information"));
		Assert.assertTrue(pdfContent.contains("Address"));

	}
}
