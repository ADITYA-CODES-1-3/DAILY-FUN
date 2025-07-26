import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class QRCodeReader {
    public static void main(String[] args) {
        try {
            // Path to the QR image
            File qrFile = new File("D:/LEARNING_JAVA/DAILY LEARNING/MyQRCode.png"); // put your image here

            // Read image
            BufferedImage bufferedImage = ImageIO.read(qrFile);

            // Prepare BinaryBitmap for ZXing to decode
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Decode the QR Code
            Result result = new MultiFormatReader().decode(bitmap);

            // Output
            System.out.println("QR Code Content: " + result.getText());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
