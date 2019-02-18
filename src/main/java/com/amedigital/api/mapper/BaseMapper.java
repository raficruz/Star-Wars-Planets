package com.amedigital.api.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * @param <B> A Base Class like a entity
 * @param <G> A generic Class that you want map like a DTO
 */
public abstract class BaseMapper<B, G> {

  public PageImpl<G> toPage(Page<B> pages, Pageable page) {
    List<G> result = new ArrayList<>();
    
    for (B b : pages) {
      result.add(toGeneric(b));
    }

    return new PageImpl<>(result, page, pages.getTotalElements());
  }

  public List<G> castListOfBaseToListOfGeneric(List<B> list) {
    List<G> result = new ArrayList<>();

    if (list == null) {
      return result;
    }

    return list.stream().map(this::toGeneric).collect(Collectors.toList());
  }

  public Set<G> castSetOfBaseToSetOfGeneric(Set<B> setList) {
    Set<G> result = new HashSet<>();

    if (setList == null) {
      return result;
    }

    for (B b : setList) {
      result.add(toGeneric(b));
    }

    return result;
  }

  public List<B> castListOfGenericToListOfBase(List<G> list) {
    List<B> result = new ArrayList<>();

    if (list == null) {
      return result;
    }

    for (G g : list) {
      if (g != null) {
        result.add(toBase(g));
      }
    }

    return result;
  }

  public Set<B> castSetOfGenericToSetOfBase(Set<G> list) {
    Set<B> result = new HashSet<>();

    if (list == null) {
      return result;
    }

    for (G g : list) {
      if (g != null) {
        result.add(toBase(g));
      }
    }

    return result;
  }

  public Set<B> castListOfGenericToSetOfBase(List<G> list) {
    Set<B> result = new HashSet<>();

    if (list == null) {
      return result;
    }

    for (G g : list) {
      if (g != null) {
        result.add(toBase(g));
      }
    }

    return result;
  }

  public List<G> castSetOfBaseToListOfGeneric(Set<B> setList) {
    List<G> result = new ArrayList<>();

    if (setList == null) {
      return result;
    }

    for (B b : setList) {
      result.add(toGeneric(b));
    }

    return result;
  }

  public abstract G toGeneric(B base);

  public abstract B toBase(G generic);
}
