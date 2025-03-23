/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author daniel
 */

package com.qguind.gymapplication;

import java.util.Scanner;

public class GymApplication {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String asciiArt = """
                  _____                _____                _
                 / ____|              |_   _|              | |
                | |  __ _   _ _ __ ___  | |  _ __ __ _  ___| | _____ _ __
                | | |_ | | | | '_ ` _ \\ | | | '__/ _` |/ __| |/ / _ \\ '__|
                | |__| | |_| | | | | | || |_| | | (_| | (__|   <  __/ |
                 \\_____|\\___, |_| |_| |_|_____|_|  \\__,_|\\___|_|\\_\\___|_|
                         __/ |
                        |___/
                """;

        System.out.println(asciiArt);

        System.out.println("Welcome to this excersise tracking application! Would you like to:");
        System.out.println("1: Login");
        System.out.println("2: Register");

    }
}
