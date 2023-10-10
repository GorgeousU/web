import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;

import java.io.IOException;
import java.util.Scanner;

public class JpcapDemo {
    public static void main(String[] args) {
        // 获取网络接口列表
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        int k = -1;
        for (NetworkInterface n : devices) {
            k++;
            System.out.println("序号 " + k + "  " + n.name + "  |  " + n.description);
            System.out.println("-----------------------");
        }

        //打开网络接口
        System.out.println("输入你想要的监听网卡序号： ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        JpcapCaptor jpcap = null;
        try {
            jpcap = JpcapCaptor.openDevice(devices[index],1512,true,5000);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("抓取数据包时出现异常");
        }
    }
}
