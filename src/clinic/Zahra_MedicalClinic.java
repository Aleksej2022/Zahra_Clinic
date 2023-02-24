package clinic;

import java.util.Scanner;

public class Zahra_MedicalClinic {

    /*
    * Project Scenario
    * You have been hired by the Zahra Medical Clinic established in Turks and Caicos to develop a patient medication analytics system
    * that will assist the medical doctors in the clinic to give the right medication dosages to child patients based on the diagnosis
    * they establish. You will need to first compute the BMI(body mass index),provide infomation about what range the BMI falls under the cardiac index(CI),
    * and then compute the body surface area(BSA) of the patients. Once the results for the BMI, cardiac index, and BSA have been established.
    * The analytics system will need to use a certain formula called the Mosteller Formula to compute the right dosage quantity to improve drug efficacy
    * and minimize drug toxicity in children.
    * */

    public static void main(String[] args) {
        String BMI_Status = "";
        Scanner user = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        String clinical_stuffusername = "Zahra123";
        String clinical_staffpassword = "Zahraportal@22";

        //Medical Staff Login Section
        System.out.printf("%80s","Welcome to the Zahra Medical Clinic Patient's Registration E-Portal");
        System.out.printf("%70s %n","---------- Medical Staff Login ----------");
        System.out.printf("%50s", "Username: ->");
        String username = user.nextLine();
        System.out.printf("%50s", "Password: ->");
        String password = user.nextLine();
        System.out.printf("%70s %n","---------- Medical Staff Login ----------");

        //Medical Staff Authentication Section
        if (username.equals(clinical_stuffusername) && password.equals(clinical_staffpassword)){
            System.out.printf("%55s %n","Login is successful!");
            System.out.println();
            System.out.printf("%70s %n", "We are now going to calculate the BMI of the patient");
            System.out.printf("%50s","Patient's name: ->");
            String patient_name = user.nextLine();

            //BMI Calculation Section
            System.out.printf("%70s %n","############# BMI Calculation #############");

            System.out.printf("%50s","Patient's Weight(kg): ->");
            double patient_weight = number.nextDouble();

            System.out.printf("%50s","Patient's Height(m): ->");
            double patient_height = number.nextDouble();

            if (patient_weight <= 0 || patient_height <= 0){
                System.out.println("Sorry, you have entered invalid values for the weight and height and/or the height of the patient");
            } else {
                System.out.printf("%70s %n","############# BMI Calculation In Progress #############");
                double BMI_calc = patient_weight / (patient_height * patient_height);
                if (BMI_calc < 18.5){
                    BMI_Status = "Underweight";
                } else if (BMI_calc >= 18.5 && BMI_calc <= 24.9){
                    BMI_Status = "Normal Weight";
                } else if (BMI_calc >= 25.0 && BMI_calc <= 29.9){
                    BMI_Status = "Overweight";
                } else if (BMI_calc >= 30){
                    BMI_Status = "Obesity";
                }
                System.out.printf("%40s %.2f %s","Patient's BMI results: -> ",BMI_calc,"kg/m^2");
                System.out.println();
                System.out.printf("%41s %10s","Patient's BMI Category: -> ",BMI_Status);
                System.out.printf("%70s %n","############# BMI Calculation In Progress #############");

                //BSA Calculation Section
                System.out.println();
                System.out.printf("%70s %n","---------- BSA Calculation ----------");
                double convert_meterToCenti = patient_height * 100;
                double BSA = Math.sqrt((convert_meterToCenti * patient_weight) / 3600);
                System.out.printf("%40s %.2f %s","Patient's BMI results: -> ",BSA,"m^2");
                System.out.printf("%70s %n","---------- BSA Calculation ----------");

                //Cardiac Index Calculation Section
                System.out.println();
                System.out.printf("%70s %n","---------- Cardiac Index ----------");
                System.out.printf("%60s", "Patient's Cardiac Output(L/Minute): -> ");
                double patient_cardiacoutput = number.nextDouble();
                double cardiac_index = patient_cardiacoutput / BSA;
                System.out.printf("%60s %.2f %s","Patient's Cardiac Index Results: -> ",cardiac_index,"L/minute/m^2");

                System.out.println();
                System.out.printf("%70s %n","---------- Cardiac Index ----------");

                System.out.println();
                //Child Patient Medication Dosage Calculation

                System.out.printf("%70s %n","---------- Medical Dosage Calculation For Children ----------");
                System.out.printf("%50s","Enter the drug name: -> ");
                String drug_name = user.nextLine();

                System.out.printf("%50s","Enter the adult dosage(mg): -> ");
                int adult_dose = number.nextInt();
                double medication_doze = (BSA/1.73) * adult_dose;
                System.out.printf("%50s $s %n","Drug name: -> ",drug_name);
                System.out.printf("%50s %.2f %s","Child Patient's Medical Dosage: -> ",medication_doze,"mg");
                System.out.printf("%70s %n","---------- Medical Dosage Calculation For Children ----------");
            }
            user.close();
            number.close();
        }
        else {
            System.out.println("Invalid Credentials!, bye bye");
        }
    }
}
