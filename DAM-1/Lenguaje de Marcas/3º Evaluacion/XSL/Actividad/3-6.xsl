<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>Peliculas:</h3>
                <ul style="list-style-type:none;">
                    <xsl:for-each select="peliculas/pelicula[valoracion='']">
                        <li>- <xsl:value-of select="titulo"/> Valoracion: <xsl:value-of select="valoracion"/></li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>