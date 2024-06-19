<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
	<html>
		<body>
			<xsl:for-each select="equipos_de_futbol">
				<h3>Equipos de:
				<value-of select="@pais"/></h3>
			</xsl:for-each>	
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>