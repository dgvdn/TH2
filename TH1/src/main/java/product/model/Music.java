package product.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Music {
	@NotBlank(message = "Code is required!")
	private String id;
	@NotBlank(message = "Description is required!")
	private String des;
	@NotBlank(message = "Price is required!")
	private Float price;

}
