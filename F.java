import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class PdfToTextConverter {

    private static final String ROOT_DIRECTORY = System.getProperty("user.dir");
    private static final String IMAGES_DIRECTORY = ROOT_DIRECTORY + "/Images/";
    private static final String RESULTS_DIRECTORY = ROOT_DIRECTORY + "/Results/";

    public static void main(String[] args) {
       
        createDirectory(IMAGES_DIRECTORY);
        createDirectory(RESULTS_DIRECTORY);

       
        System.out.println("Pu ");

        
        long startTime = System.currentTimeMillis();

        
        List<String> allPdfNames = getPdfFilesNames();

     
        convertPdfsToImages(allPdfNames);

    
        convertImagesToText(allPdfNames);

        cleanUpFolders(getFolderNames());

        System.out.println("~");
        System.out.println("");
    }

    private static void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() && !directory.mkdirs()) {
            System.err.println("Failed to create directory: " + directoryPath);
            System.exit(1);
        }
    }

   

   
