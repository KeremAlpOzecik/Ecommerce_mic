package com.micro.orderservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private Long cartId;
    private Long productId;
    @Column (name = "quantity")
    @NotNull
    private int quantity;
    @Column (name = "subtotal")
    @NotNull
    private BigDecimal subTotal;






    

}
