import fish.payara.micro.PayaraMicroRuntime;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class EmbeddedPayaraMicroForDevelopment {

    public static void main(String[] args) throws BootstrapException, IOException {
        PayaraMicroRuntime payaraMicroRuntime = PayaraMicro.getInstance().bootStrap();

        int c;
        while (-1 != (c = System.in.read())) {
            payaraMicroRuntime.getDeployedApplicationNames().forEach(payaraMicroRuntime::undeploy);
            payaraMicroRuntime.deploy(new File("build/libs/app.war"));
        }

        /*
        try (ServerSocket serverSocket = new ServerSocket(18081)) {
            System.out.println("EchoServerが起動しました(port="
                    + serverSocket.getLocalPort() + ")");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("接続されました " + socket.getRemoteSocketAddress());
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                    //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("受信: " + line);
                    }

                    payaraMicroRuntime.getDeployedApplicationNames().forEach(payaraMicroRuntime::undeploy);
                    payaraMicroRuntime.deploy(new File("build/libs/app.war"));
                }
            }
        }
        */
    }

}
