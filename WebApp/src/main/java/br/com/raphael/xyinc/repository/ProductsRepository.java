package br.com.raphael.xyinc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.raphael.xyinc.repository.entity.ProductsEntity;;

public class ProductsRepository {
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public ProductsRepository() {

		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_xyinc");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	public void Salvar(ProductsEntity productsEntity) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(productsEntity);
		this.entityManager.getTransaction().commit();
	}

	public void Alterar(ProductsEntity productsEntity) {

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(productsEntity);
		this.entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<ProductsEntity> getProducts() {

		return this.entityManager.createQuery("SELECT p FROM ProductsEntity p ORDER BY p.name").getResultList();
	}

	public ProductsEntity GetProduct(Integer id) {

		return this.entityManager.find(ProductsEntity.class, id);
	}

	public void Excluir(Integer id) {

		ProductsEntity product = this.GetProduct(id);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(product);
		this.entityManager.getTransaction().commit();

	}
}
