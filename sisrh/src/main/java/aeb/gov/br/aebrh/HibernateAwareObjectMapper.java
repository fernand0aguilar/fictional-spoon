package aeb.gov.br.aebrh;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 3313336664121614511L;

	public HibernateAwareObjectMapper() {
		registerModule(new Hibernate5Module());
		this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		this.configure(SerializationFeature.INDENT_OUTPUT, true);
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
}
