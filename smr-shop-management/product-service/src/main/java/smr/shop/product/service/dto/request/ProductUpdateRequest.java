package smr.shop.product.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ProductUpdateRequest {

    @NotBlank
    String name;

    @NotBlank
    String slug;

    @NotBlank
    String description;

    @NotBlank
    String tags;

    @NotNull
    Double price;

    @NotNull
    Double minPrice;

    @NotNull
    Double maxPrice;

    @NotNull
    Double shippingPrice;

}
