package com.tcp.site.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = SlingHttpServletRequest.class,
resourceType = Sample.RESOURCE_TYPE,
adapters = {Sample.class, ComponentExporter.class},
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class Sample implements ComponentExporter{

	protected static final String RESOURCE_TYPE = "tcp-site/components/tcp-pwa/sample";

	@ValueMapValue(name = "text")
	private String text;
	
	public String getText() {
		return text;
	}

	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}

}
