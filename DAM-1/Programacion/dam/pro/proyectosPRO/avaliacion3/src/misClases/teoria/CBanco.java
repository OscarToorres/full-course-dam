package misClases.teoria;

public class CBanco {
	private CCuenta[] clientes;
	private int nElementos;

	public CBanco() {
		this.nElementos = 0;
		this.clientes = new CCuenta[this.nElementos];
	}

	private void unElementoMas(final CCuenta[] clientesActuales) {
		this.nElementos = clientesActuales.length;
		this.clientes = new CCuenta[this.nElementos + 1];
		for (int i = 0; i < this.nElementos; ++i) {
			this.clientes[i] = clientesActuales[i];
		}
		++this.nElementos;
	}

	private void unElementoMenos(final CCuenta[] clientesActuales) {
		if (clientesActuales.length == 0) {
			return;
		}
		int k = 0;
		this.nElementos = clientesActuales.length;
		this.clientes = new CCuenta[this.nElementos - 1];
		for (int i = 0; i < this.nElementos; ++i) {
			if (clientesActuales[i] != null) {
				this.clientes[k++] = clientesActuales[i];
			}
		}
		--this.nElementos;
	}

	public void insertarCliente(final int i, final CCuenta objeto) {
		if (i >= 0 && i < this.nElementos) {
			this.clientes[i] = objeto;
		} else {
			System.out.println("\ufffdndice fuera de l\ufffdmites");
		}
	}

	public CCuenta clienteEn(final int i) {
		if (i >= 0 && i < this.nElementos) {
			return this.clientes[i];
		}
		System.out.println("\ufffdndice fuera de l\ufffdmites");
		return null;
	}

	public int longitud() {
		return this.nElementos;
	}

	public void anhadir(final CCuenta obj) {
		this.unElementoMas(this.clientes);
		this.insertarCliente(this.nElementos - 1, obj);
	}

	public boolean eliminar(final String cuenta) {
		for (int i = 0; i < this.nElementos; ++i) {
			if (cuenta.compareTo(this.clientes[i].obtenerCuenta()) == 0) {
				this.clientes[i] = null;
				this.unElementoMenos(this.clientes);
				return true;
			}
		}
		return false;
	}

	public int buscar(final String str, int pos) {
		if (str == null) {
			return -1;
		}
		if (pos < 0) {
			pos = 0;
		}
		for (int i = pos; i < this.nElementos; ++i) {
			final String nom = this.clientes[i].obtenerNombre();
			if (nom != null) {
				if (nom.indexOf(str) > -1) {
					return i;
				}
				final String cuen = this.clientes[i].obtenerCuenta();
				if (cuen != null) {
					if (cuen.indexOf(str) > -1) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	public void mostrar() {
		for (int i = 0; i < this.nElementos; ++i) {
			this.clientes[i].mostrar();
		}
	}
}