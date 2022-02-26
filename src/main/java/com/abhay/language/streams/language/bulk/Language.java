package com.abhay.language.streams.language.bulk;

public class Language 
{ 
    public String name; 
    public LanguageType type; 
    public String description;
    public double price;
    public enum LanguageType {HARD, OK, EASY} 
 
    public Language(String langName, LanguageType langType, 
        String langDescription,double langPrice) 
    { 
        name = langName; 
        type = langType; 
        description = langDescription; 
        price=langPrice;
    } 
    public String toString() 
    { 
        return name; 
    } 
    
}