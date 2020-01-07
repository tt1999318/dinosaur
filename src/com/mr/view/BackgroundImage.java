
package com.mr.view;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 滚动背景
 * 
 * @author mingrisoft
 *
 */
public class BackgroundImage {
    public BufferedImage image;// 背景图片
    private BufferedImage image1, image2, image3;// 滚动的三个图片
    private Graphics2D g;// 背景图片的绘图对象
    public int x1, x2,x3;// 三个滚动图片的坐标
    public static final int SPEED = 4;// 滚动速度

    public BackgroundImage() {
        try {
            image1 = ImageIO.read(new File("image/背景.png"));
            image2 = ImageIO.read(new File("image/背景.png"));
            image3 = ImageIO.read(new File("image/背景.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 主图片采用宽800高300的彩色图片
        image = new BufferedImage(800, 300, BufferedImage.TYPE_INT_RGB);
        g = image.createGraphics();// 获取主图片绘图对象
        x1 = 0;// 第一幅图片初始坐标为0
        x2 = 800;// 第二幅图片初始横坐标为800
        x3 = 1600;// 第三幅图片初始横坐标为1600
        g.drawImage(image1, x1, 0, null);
    }
    /**
     * 滚动
     */
    public void roll() {
        x1 -= SPEED;// 第一幅图片左移
        x2 -= SPEED;// 第二幅图片左移
        x3 -= SPEED;// 第三幅图片左移
        if (x1 <= -800) {// 如果第一幅图片移出屏幕
            x1 = 800;// 回到屏幕右侧
        }
        if (x2 <= -800) {// 如果第二幅图片移出屏幕
            x2 = 800;// 回到屏幕右侧
        }
        if (x3 <= -800) {// 如果第三幅图片移出屏幕
            x3 = 800;// 回到屏幕右侧
        }
        g.drawImage(image1, x1, 0, null); // 在主图片中绘制三幅图片
        g.drawImage(image2, x2, 0, null);
        g.drawImage(image3, x3, 0, null);
    }
}
