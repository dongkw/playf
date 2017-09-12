package common.jdbc.datasource;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import play.Play;

import com.jolbox.bonecp.BoneCPDataSource;

public class BoneCPDataSourceFactoryBean implements FactoryBean<BoneCPDataSource>, InitializingBean{
	
	private BoneCPDataSource boneCPDataSource;
	
	public final static int DEFAULT_POOL_MAX_SIZE = 200;
	
	public final static int DEFAULT_POOL_MIN_SIZE = 10;
	
	

	@Override
	public BoneCPDataSource getObject() throws Exception {
		return boneCPDataSource;
	}

	@Override
	public Class<?> getObjectType() {
		return BoneCPDataSource.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		boneCPDataSource = new BoneCPDataSource();
		boneCPDataSource.setJdbcUrl(Play.configuration.getProperty("db.url"));
		boneCPDataSource.setUsername(Play.configuration.getProperty("db.user"));
		boneCPDataSource.setPassword(Play.configuration.getProperty("db.pass"));
		boneCPDataSource.setDriverClass(Play.configuration.getProperty("db.driver"));
		boneCPDataSource.setMaxConnectionsPerPartition(getIntValue("db.pool.maxSize", DEFAULT_POOL_MAX_SIZE));
		boneCPDataSource.setMinConnectionsPerPartition(getIntValue("db.pool.minSize", DEFAULT_POOL_MIN_SIZE));
		boneCPDataSource.setConnectionTimeout(15, TimeUnit.SECONDS);//超时时间为15秒
		boneCPDataSource.setPartitionCount(4);//4个分区
	}
	
	public int getIntValue(String config, int defalutValue){
		String value = Play.configuration.getProperty(config );
		if(!StringUtils.isEmpty(value)){
			try{
				defalutValue = Integer.parseInt(value);
			}catch (Exception e) {
			}
		}
		return defalutValue;
	}

}
