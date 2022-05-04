package by.car.dealership.dao;

import by.car.dealership.entity.Engine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.car.dealership.dao.MockConstants.*;
import static by.car.dealership.dao.MockUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class EngineDaoImplTest {

    GenericDao<Engine> engineDao = new EngineDaoImpl();

    @Test
    void createTest() {

        Engine engine = engineDao.create(createEngine());

        try {
            Engine entityEngine = engineDao.findOne(engine.getId());
            assertEquals(engine, entityEngine);
            Assertions.assertEquals(entityEngine.getName(), ENGINE_NAME);
            Assertions.assertEquals(entityEngine.getModel(), ENGINE_MODEL);
            engineDao.delete(engine);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findOneTest() {

        Engine engine = engineDao.create(createEngine());
        Integer engineId = engine.getId();

        try {
            assertEquals(engine, engineDao.findOne(engineId));
            engineDao.delete(engine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAllTest() {

        Engine engine = engineDao.create(createEngine());
        Engine engine2 = engineDao.create(createEngine());

        List<Engine> myListEngines = new ArrayList<>();
        myListEngines.add(engine);
        myListEngines.add(engine2);

        List<Engine> listFromDb = engineDao.findAll();

        assertEquals(myListEngines, listFromDb);

        engineDao.delete(engine);
        engineDao.delete(engine2);
    }

    @Test
    void updateTest() {

        Engine engine = engineDao.create(createEngine());
        engine.setFuelType(DIESEL_FUEL);
        engineDao.update(engine);

        try {
            Engine entityEngine = engineDao.findOne(engine.getId());

            assertEquals(engine, entityEngine);
            Assertions.assertEquals(entityEngine.getFuelType(), DIESEL_FUEL);
            engineDao.delete(engine);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteTest() {

        Engine engine = engineDao.create(createEngine());

        List<Engine> engineList1 = engineDao.findAll();

        engineDao.delete(engine);

        List<Engine> engineList2 = engineDao.findAll();

        assertTrue(engineList1.contains(engine));
        assertFalse(engineList2.contains(engine));
    }

    @Test
    void deleteByIdTest() {

        Engine engine = engineDao.create(createEngine());
        List<Engine> engineList1 = engineDao.findAll();

        Integer currentEngineId = engine.getId();

        try {
            engineDao.deleteById(currentEngineId);

            List<Engine> engineList2 = engineDao.findAll();

            assertTrue(engineList1.contains(engine));
            assertFalse(engineList2.contains(engine));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}