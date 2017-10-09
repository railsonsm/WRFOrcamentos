package br.cairu.pi.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemaMB {
	private String tema = "start";

	public String[] getTemas() {
	    return new String[] {"afternoon","afterwork","aristo","black-tie","blitzer","bluesky","bootstrap",
	    		"casablanca","cupertino","cruze","dark-hive","delta","dot-luv","eggplant","excite-bike",
	    		"flick","glass-x","home","hot-sneaks","humanity","le-frog","midnight","mint-choc",
	    		"overcast","pepper-grinder","redmond","rocket","sam","smoothness","south-street",
	    		"start","sunny","swanky-purse","trontastic","ui-darkness","ui-lightness","vader"};
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}



}
