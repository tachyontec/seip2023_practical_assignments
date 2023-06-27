package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ToStringSourceFileReaderTest {

    @Test
    public void testRead_LocalFile_Success() throws IOException {
        // Arrange
        String expectedContent = "public class Class1 {\n" +
                "\t\t// simple comment\n" +
                "// simple comment 2\n" +
                "\n" +
                " /* long comment 1 */\n" +
                " \n" +
                " /* \n" +
                " * \n" +
                " * long comment 2 \n" +
                " */\n" +
                "\n" +
                "\tpublic void foo() {}\n" +
                "\n" +
                "\tString foo2() {\n" +
                "\t\tint x = Math.pow(2,2);\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class Class2{\n" +
                "\n" +
                "\tstatic void foo3(){\n" +
                "\n" +
                "} \n" +
                "\n" +
                "}\n" +
                "\n" +
                "class Class3 {\n" +
                "\t/***\n" +
                "\t*\n" +
                "\t* Javadoc comment\n" +
                "\t*/\n" +
                "}\n";
        String filepath = "src/test/resources/TestClass.java";
        String locationType = "local";
        ToStringSourceFileReader reader = new ToStringSourceFileReader();

        // Act
        String actualContent = reader.read(filepath, locationType);

        // Assert
        Assert.assertEquals(expectedContent.trim(), actualContent.trim());
    }

    @Test
    public void testRead_WebFile_Success() throws IOException {
        // Arrange
        String expectedContent = "package main.game;\n" +
                "\n" +
                "import java.awt.*;\n" +
                "import java.awt.image.BufferedImage;\n" +
                "\n" +
                "//this class draws the animation in the screen\n" +
                "public class Animation {\n" +
                "    public int frames; // how many photos we have to change for the animation to be done\n" +
                "    public int speed; //the speed that we change the photos\n" +
                "    public int index = 0;\n" +
                "    public int count = 0;\n" +
                "    public BufferedImage[] images; //the images that are needed for the animation\n" +
                "    public BufferedImage currentImg;//used to refer to the current image while drawing the animation\n" +
                "\n" +
                "    //constructor that gets a list or a table of BufferedImage\n" +
                "    //its initializes the images table\n" +
                "    public Animation(int speed, BufferedImage... args) {\n" +
                "        images = new BufferedImage[args.length];\n" +
                "        //The speed will depend on how many images we have\n" +
                "        this.speed = 60 / args.length - speed; // bigger speed -> slower animation and vice versa\n" +
                "        //Copy args array into images:\n" +
                "        System.arraycopy(args, 0, images, 0, args.length);\n" +
                "        this.frames = args.length;\n" +
                "    }\n" +
                "\n" +
                "    //calling this method makes the animation run in backend\n" +
                "    public void runAnimation() {\n" +
                "        index++;\n" +
                "        if (index > speed) {\n" +
                "            index = 0;\n" +
                "            nextFrame();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    //this method changes the frame\n" +
                "    public void nextFrame() {\n" +
                "        for (int i = 0; i < frames; i++) {\n" +
                "            if (count == i) {\n" +
                "                currentImg = images[i];\n" +
                "            }\n" +
                "        }\n" +
                "        count++;\n" +
                "        if (count > frames) {\n" +
                "            count = 0;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public void drawAnimation(Graphics2D g, int x, int y, int scalex, int scaley) {\n" +
                "        g.drawImage(currentImg, x, y, scalex, scaley, null);\n" +
                "    }\n" +
                "\n" +
                "    public void drawAnimation(Graphics2D g, int x, int y) {\n" +
                "        g.drawImage(currentImg, x, y, null);\n" +
                "    }\n" +
                "}\n";
        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String locationType = "web";
        ToStringSourceFileReader reader = new ToStringSourceFileReader();

        // Act
        String actualContent = reader.read(filepath, locationType);
        // Assert
        Assert.assertEquals(expectedContent, actualContent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRead_InvalidLocationType_ExceptionThrown() throws IOException {
        // Arrange
        String filepath = "src/test/resources/TestClass.java";
        String locationType = "invalid";
        ToStringSourceFileReader reader = new ToStringSourceFileReader();

        // Act
        reader.read(filepath, locationType);

        // Expecting IllegalArgumentException to be thrown
    }
}
