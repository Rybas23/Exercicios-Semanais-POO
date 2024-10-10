package src.M4;

import src.M2.Aluno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainM4 {
    public static void main(String[] args) throws FileNotFoundException {

        //Testes 4.1
        System.out.println("Teste 4.1\n");

        Circle c1 = new Circle(1,1,2);
        Circle c2 = new Circle(5,5, 3);
        Rectangle r1 = new Rectangle(10,10,10,5);
        Rectangle r2 = new Rectangle(25,0,15,10);
        Rectangle r3 = new Rectangle(45,0,35,40);

        Canvas canvas = new Canvas();
        canvas.add(c1);
        canvas.add(c2);
        canvas.add(r1);
        canvas.add(r2);
        canvas.add(r3);

        canvas.remove(r3);

        for(Figure f : canvas.getListFigures()) {
            System.out.println(f + " || Area: " + f.getArea() + " || Perimeter: " + f.getPerimeter() + "");
        }

        System.out.println("Total das areas: " + canvas.sumOfAreas() + "\n");

        System.out.println("Remove biggest area: \n");
        canvas.removeBiggestArea();

        for(Figure f : canvas.getListFigures()) {
            System.out.println(f + " || Area: " + f.getArea() + " || Perimeter: " + f.getPerimeter() + "");
        }

        System.out.println("Total das areas: " + canvas.sumOfAreas() + "\n");

        //Teste alunos 4.2
        System.out.println("Teste 4.2\n");

        File fileAlunos = new File("alunos.txt");
        LineStudentReader studentReader = new LineStudentReader(fileAlunos);

        List<Aluno> alunos = studentReader.read();
        for (Aluno a : alunos) {
            System.out.println(a);
        }

        System.out.println("");

        //Teste circulos 4.2
        File fileCirculos = new File("circulos.txt");
        LineCircleReader circleReader = new LineCircleReader(fileCirculos);

        List<Circle> circles = circleReader.read();
        for(Circle c : circles) {
            System.out.println(c);
        }

        System.out.println("");

        //Testes 4.3
        System.out.println("Teste 4.3\n");

        Empregado e1 = new Empregado("Lee Sin",1);
        Empregado e2 = new Empregado("Karthus",2);
        Empregado e3 = new Empregado("Rumble",3);
        Empregado e4 = new Empregado("Alistar",4);
        Gerente g1 = new Gerente("Grt Darius",6);
        Gerente g2 = new Gerente("Grt Garen",7);
        Diretor d1 = new Diretor("Dr Heimerdinger",8);

        Empresa empresa = new Empresa();
        empresa.add(e1);
        empresa.add(e2);
        empresa.add(e3);
        empresa.add(e4);
        empresa.add(g1);
        empresa.add(g2);
        empresa.add(d1);

        g1.setObjetivoCumprido();
        d1.setLucro(8000.0);

        for(Empregado e : empresa.empregados) {
            System.out.println(e);
        }

        System.out.println("Total de salários: " + empresa.calcularSalarios() + " euros\n");

        //Testes 4.4
        System.out.println("Teste 4.4\n");

        Cliente cliente1 = new Cliente("Francisco", "123", 1250);
        Cliente cliente2 = new Cliente("João", "123", 1500);
        Cliente cliente3 = new Cliente("Luis", "123", 700);
        Cliente cliente4 = new Cliente("Miguel", "123", 1300);
        Cliente cliente5 = new Cliente("Antonio", "123", 500);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

        System.out.println("Clientes:");

        for(Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        List<ClienteVIP> clienteVIPs = getClientesVip(clientes);

        System.out.println("\nClientes VIP:");

        for(ClienteVIP clienteVIP : clienteVIPs) {
            System.out.println(clienteVIP);
        }

        System.out.println("\nClientes Atualizados:");

        for(Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public static List<ClienteVIP> getClientesVip(List<Cliente> clientes) {
        List<ClienteVIP> clientesVip = new ArrayList<>();
        List<Cliente> clientesClone = new ArrayList<>(clientes);

        for(Cliente cliente : clientesClone) {
            if(cliente.getMediaCompras() > ClienteVIP.vipValue) {
                clientesVip.add(new ClienteVIP(cliente.getNome(), cliente.getIdentificacao(), cliente.getMediaCompras(), 0.10));
                clientes.remove(cliente);
            }
        }

        return clientesVip;
    }
}
