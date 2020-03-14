package com.duopharma.lang;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
@ManagedBean(name="language")
@ViewScoped
public class LanguageBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Locale locale;
	
	private String localeCode;
	private static Map<String,Object> countries;
	
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("Spanish", new Locale("es", "ES"));
		countries.put("English", Locale.ENGLISH); //label, value
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){
		String newLocaleValue = e.getNewValue().toString();
                for (Map.Entry<String, Object> entry : countries.entrySet()) {
        
	        	   if(entry.getValue().toString().equals(newLocaleValue)){
	        		
	        		FacesContext.getCurrentInstance()
	        			.getViewRoot().setLocale((Locale)entry.getValue());
	        		locale = FacesContext.getCurrentInstance()
	    			.getViewRoot().getLocale();
	        	  }
               }
	}
	
	 public void changeLanguage(String language){
		 FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
 		locale = FacesContext.getCurrentInstance()
			.getViewRoot().getLocale();
	 }

}
