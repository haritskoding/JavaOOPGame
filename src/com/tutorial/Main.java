package com.tutorial;

//player
class Player {
    String name;
    double health;
    int level;

    // objek member
    Weapon weapon;
    Armor armor;

    Player(String name, double health) {
        this.name = name;
        this.health = health;
    }

    void attack(Player opponent) {
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name + " attacking " + opponent.name + " with power " + attackPower);
        opponent.defence(attackPower);
    }

    void defence(double attackPower) {
        // akan mengambil damage ny
        // kalau ttack power > defencePower, maka damage= attackPower-defencce power
        double damage;
        if (this.armor.defencePower < attackPower) {
            damage = attackPower - this.armor.defencePower;
        } else {
            damage = 0;
        }
        this.health -= damage;
        System.out.println(this.name + " got damage " + damage);
    }

    void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    void equipArmor(Armor armor) {
        this.armor = armor;
    }

    void display() {
        System.out.println("\nName: " + this.name);
        System.out.println("Health : " + this.health + " hp");
        this.weapon.display();
        this.armor.display();
    }
}

// senjata
class Weapon {
    double attackPower;
    String name;

    Weapon(String name, double attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    void display() {
        System.out.println("Weapon : " + this.name + " ,attack : " + this.attackPower);
    }
}

// armor
class Armor {
    String name;
    double defencePower;

    Armor(String name, double defencePower) {
        this.name = name;
        this.defencePower = defencePower;
    }

    void display() {
        System.out.println("Armor : " + this.name + " , defence : " + this.defencePower);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        // membuat objek player
        Player player1 = new Player("Ucup", 100);
        Player player2 = new Player("Otong ", 50);

        // membuat objecct weapon
        Weapon pedang = new Weapon("Pedang", 15);
        Weapon ketpel = new Weapon("Ketapel", 1);

        // membuat objek armor
        Armor bajuBesi = new Armor("Baju Besi", 10);
        Armor kaos = new Armor("Kaos", 0);

        // equip senjata dan armor
        player1.equipWeapon(pedang);
        player1.equipArmor(bajuBesi);
        player1.display();

        // player2
        player2.equipWeapon(ketpel);
        player2.equipArmor(kaos);
        player2.display();

        System.out.println("\n Pertempuran dimulai");
        System.out.println("\n Episode - 1");
        player1.attack(player2);
        player1.display();

        System.out.println("\n Episode - 2");
        player2.attack(player1);
        player2.display();

    }
}
