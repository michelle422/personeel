package be.vdab.web;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

class OpslagForm {
	@NotNull
	@Min(1)
	private BigDecimal salaris;

	public BigDecimal getSalaris() {
		return salaris;
	}

	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;
	}
	
}
