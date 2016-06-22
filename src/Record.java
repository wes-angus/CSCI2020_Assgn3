/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 100449718
 */
public class Record
{
    String sector;
    String employer;
    String name; // lastname, firstname
    String position;
    double salary;
    
    Record(String sector, String employer, String name, String position, double salary)
    {
        this.sector = sector;
        this.employer = employer;
        //replace special/accented characters for readability
        this.employer = this.employer.replaceAll("&egrave;", "è");
        this.employer = this.employer.replaceAll("&eacute;", "é");
        this.employer = this.employer.replaceAll("&agrave;", "à");
        this.employer = this.employer.replaceAll("&auml;", "ä");
        this.employer = this.employer.replaceAll("&ccedil;", "ç");
        this.employer = this.employer.replaceAll("&euml;", "ë");
        this.employer = this.employer.replaceAll("&ocirc;", "ô");
        this.employer = this.employer.replaceAll("&iuml;", "ï");
        this.employer = this.employer.replaceAll("&acirc;", "â");
        this.employer = this.employer.replaceAll("&icirc;", "î");
        this.employer = this.employer.replaceAll("&ecirc;", "ê");
        this.employer = this.employer.replaceAll("&oelig;", "œ");
        this.employer = this.employer.replaceAll("&ucirc;", "û");
        this.employer = this.employer.replaceAll("&Egrave;", "È");
        this.employer = this.employer.replaceAll("&Eacute;", "É");
        this.employer = this.employer.replaceAll("&Agrave;", "À");
        this.employer = this.employer.replaceAll(" &Agrave ", " À ");
        this.employer = this.employer.replaceAll("&Auml;", "Ä");
        this.employer = this.employer.replaceAll("&Ccedil;", "Ç");
        this.employer = this.employer.replaceAll("&Euml;", "Ë");
        this.employer = this.employer.replaceAll("&Ocirc;", "Ô");
        this.employer = this.employer.replaceAll("&Iuml;", "Ï");
        this.employer = this.employer.replaceAll("&Acirc;", "Â");
        this.employer = this.employer.replaceAll("&Icirc;", "Î");
        this.employer = this.employer.replaceAll("&Ecirc;", "Ê");
        this.employer = this.employer.replaceAll("&OElig;", "Œ");
        this.employer = this.employer.replaceAll("&Ucirc;", "Û");
        this.employer = this.employer.replaceAll("&rsquo;", "’");
        this.employer = this.employer.replaceAll(" & ", " and ");
        this.name = name;
        this.name = this.name.replaceAll("&Egrave;", "È");
        this.name = this.name.replaceAll("&Eacute;", "É");
        this.name = this.name.replaceAll("&Agrave;", "À");
        this.name = this.name.replaceAll("&Auml;", "Ä");
        this.name = this.name.replaceAll("&Ccedil;", "Ç");
        this.name = this.name.replaceAll("&Euml;", "Ë");
        this.name = this.name.replaceAll("&Ocirc;", "Ô");
        this.name = this.name.replaceAll("&Iuml;", "Ï");
        this.position = position;
        this.position = this.position.replaceAll("&egrave;", "è");
        this.position = this.position.replaceAll("&eacute;", "é");
        this.position = this.position.replaceAll("&agrave;", "à");
        this.position = this.position.replaceAll("&auml;", "ä");
        this.position = this.position.replaceAll("&ccedil;", "ç");
        this.position = this.position.replaceAll("&euml;", "ë");
        this.position = this.position.replaceAll("&ocirc;", "ô");
        this.position = this.position.replaceAll("&iuml;", "ï");
        this.position = this.position.replaceAll("&acirc;", "â");
        this.position = this.position.replaceAll("&icirc;", "î");
        this.position = this.position.replaceAll("&ecirc;", "ê");
        this.position = this.position.replaceAll("&oelig;", "œ");
        this.position = this.position.replaceAll("&ucirc;", "û");
        this.position = this.position.replaceAll("&Egrave;", "È");
        this.position = this.position.replaceAll("&Eacute;", "É");
        this.position = this.position.replaceAll("&Agrave;", "À");
        this.position = this.position.replaceAll(" &Agrave ", " À ");
        this.position = this.position.replaceAll("&Auml;", "Ä");
        this.position = this.position.replaceAll("&Ccedil;", "Ç");
        this.position = this.position.replaceAll("&Euml;", "Ë");
        this.position = this.position.replaceAll("&Ocirc;", "Ô");
        this.position = this.position.replaceAll("&Iuml;", "Ï");
        this.position = this.position.replaceAll("&Acirc;", "Â");
        this.position = this.position.replaceAll("&Icirc;", "Î");
        this.position = this.position.replaceAll("&Ecirc;", "Ê");
        this.position = this.position.replaceAll("&OElig;", "Œ");
        this.position = this.position.replaceAll("&Ucirc;", "Û");
        this.position = this.position.replaceAll("&rsquo;", "’");
        this.position = this.position.replaceAll(" & ", " and ");
        this.salary = salary;
    }
}
