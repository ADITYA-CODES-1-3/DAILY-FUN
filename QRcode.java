import java.io.File;
import java.io.IOException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRcode {
    public static void main(String[] args) {
        String data = "https://github.com/ADITYA-CODES-1-3/SEC-LAB/tree/main/Home-Task-js";
        int width = 300;
        int height = 300;
        String filePath = "MyQRCode.png";

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
            File file = new File(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", file.toPath());
            System.out.println(" QR Code generated at: " + file.getAbsolutePath());
        } catch (WriterException | IOException e) {
            System.err.println(" Error: " + e.getMessage());
        }
    }
}
