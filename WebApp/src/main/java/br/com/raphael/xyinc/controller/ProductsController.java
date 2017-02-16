package br.com.raphael.xyinc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.raphael.xyinc.http.*;
import br.com.raphael.xyinc.repository.*;
import br.com.raphael.xyinc.repository.entity.ProductsEntity;

@Path("/products")
public class ProductsController {

	private final ProductsRepository repo = new ProductsRepository();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/add")
	public String Add(Products products) {

		ProductsEntity entity = new ProductsEntity();

		try {
			entity.setName(products.getName());
			entity.setDescription(products.getDescription());
			entity.setPrice(products.getPrice());
			entity.setCategory(products.getCategory());

			repo.Salvar(entity);

			return "Success";

		} catch (Exception e) {
			return "Failed" + e.getMessage();
		}
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/edit")
	public String Edit(Products products) {

		ProductsEntity entity = new ProductsEntity();

		try {
			entity.setId(products.getId());
			entity.setName(products.getName());
			entity.setDescription(products.getDescription());
			entity.setPrice(products.getPrice());
			entity.setCategory(products.getCategory());

			repo.Alterar(entity);

			return "Succes";
		} catch (Exception e) {
			return "Failed" + e.getMessage();
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getall")
	public List<Products> GetAll() {
		List<Products> products = new ArrayList<Products>();

		List<ProductsEntity> listaEntity = repo.getProducts();

		for (ProductsEntity entity : listaEntity) {
			products.add(new Products(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(),
					entity.getCategory()));
		}

		return products;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getproduct/{id}")
	public Products GetProduct(@PathParam("id") Integer id) {
		ProductsEntity entity = repo.GetProduct(id);

		if (entity != null)
			return new Products(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(),
					entity.getCategory());

		return null;

	}

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/delete/{id}")
	public String delete(@PathParam("id") Integer id) {
		try {

			repo.Excluir(id);

			return "Success";
		} catch (Exception e) {
			return "Failed" + e.getMessage();
		}
	}
}
