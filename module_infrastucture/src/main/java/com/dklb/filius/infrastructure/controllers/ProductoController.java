package com.dklb.filius.infrastructure.controllers;

import com.dklb.filius.infrastructure.helpers.models.general.GeneralRequest;
import com.dklb.filius.infrastructure.helpers.models.request.ProductRequest.BusinessIdRequest;
import com.dklb.filius.infrastructure.helpers.models.request.ProductRequest.ProductRequest;
import com.dklb.filius.infrastructure.helpers.models.general.Resultado;
import com.dklb.filius.infrastructure.helpers.models.request.loginRequest.LoginRequest;
import com.dklb.filius.infrastructure.service.ProductLayerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping("/filiusApi")
public class ProductoController {
    @Autowired
    private ProductLayerService productLayerService;
    ModelMapper modelMapper=new ModelMapper();

    @GetMapping("/free/obtener-productos-user")
    public ResponseEntity<?>  obtenerProductos (@Valid @RequestBody GeneralRequest generalRequest){

        ProductRequest productRequest= modelMapper.map(generalRequest.getBody(),ProductRequest.class);
        Resultado resultado =new Resultado();
        resultado.mensaje="se listaron los productos del usuario";
        System.out.println(productRequest.getBusinessId());
        resultado.respuesta= productLayerService.getProductsByBusinnesId(productRequest.getBusinessId());
        return new ResponseEntity<>(resultado,HttpStatus.OK);
    }

    @PostMapping("/free/guardar-producto")
    public ResponseEntity<Resultado> guardarProducto(
            @Valid @RequestBody ProductRequest product){
        Resultado resultado =new Resultado();
        Boolean guardo=productLayerService.saveProduct(product);
        if (!guardo) {
            resultado.mensaje="El producto existe";
            resultado.respuesta=false;
            return new ResponseEntity<>(resultado,HttpStatus.CONFLICT);
        }
        productLayerService.saveProduct(product);
        resultado.mensaje="se guardo el producto exitosamente";
        resultado.respuesta=true;
      return new ResponseEntity<>(resultado,HttpStatus.CREATED);

    }








}
